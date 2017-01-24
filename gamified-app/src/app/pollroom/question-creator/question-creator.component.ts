import {
    Component, OnInit, style, animate, transition,
    state, trigger, Input, EventEmitter, Output
} from '@angular/core';

import { Question, Answer } from '../../models/question';

import {PollroomService} from "../../services/pollroom.service";
import {QuestionCreationDTO} from "../../models/question-creation-dto";
import {QuestionUpdateInfosDTO} from "../../models/question-update-infos-dto";

@Component({
    moduleId: module.id,
    selector: 'question-creator',
    templateUrl: 'question-creator.component.html',
    styleUrls: ['question-creator.component.css'],
    animations: [
        trigger('flyInOut', [
            state('in', style({opacity: 1, transform: 'translateX(0)'})),
            transition('void => *', [
                style({
                    opacity: 0,
                    transform: 'translateX(-100%)'
                }),
                animate('0.2s ease-in')
            ]),
            transition('* => void', [
                animate('0.2s 10 ease-out', style({
                    opacity: 0,
                    transform: 'translateX(100%)'
                }))
            ])
        ]),
        trigger('comeInOut', [
            state('in', style({opacity: 1, transform: 'translateX(0)'})),
            transition('void => *', [
                style({
                    opacity: 0,
                    transform: 'translateX(0) scale(0)'
                }),
                animate(200)
            ])
        ])
    ]
})
export class QuestionCreatorComponent implements OnInit {

    @Input() question: Question;
    originalQuestion: Question; // in case of question editing
    @Output() onPublish = new EventEmitter<Question>();
    @Output() onUpdate = new EventEmitter<Question>();
    @Output() onUpdateCanceled = new EventEmitter();
    @Input() pollroomId;
    @Input() socket;
    @Input() pollroomIdentifier;
    @Input() pollroom;

    private published: boolean = false;
    private isFocus = false;
    private isEditing = false;

    private MIN_ANSWER = 2;
    private MAX_ANSWER = 10;

    constructor(private pollroomService: PollroomService) { }

    ngOnInit() {
        this.initQuestion();
    }

    // Publish the created question
    publish() {
        let verifications = this.questionVerifications();

        if (verifications.error_message) {
            console.log(verifications.error_message);
        } else {
            let questionCreationDTO = new QuestionCreationDTO(this.pollroomId,
                this.question.title.trim(), verifications.answers);

            this.pollroomService.addQuestion(this.pollroomId, questionCreationDTO).then(
                question => {
                    console.log(question);
                    this.socket.emit('newQuestion', { room: this.pollroomIdentifier, question: question});
                    this.hideFullQuestion();
                    this.initQuestion();
                },
                error => console.log(error, "Error")
            );
        }
    }

    update() {
        let verifications = this.questionVerifications();

        if (verifications.error_message) {
            console.log(verifications.error_message);
        } else {

            let answers: string[] = [];
            this.question.answers.forEach(a => answers.push(a.label));
            let dto = new QuestionUpdateInfosDTO(this.question.id, this.question.status, this.question.title.trim(), answers);

            this.pollroomService.patchQuestion(dto).then(
                question => {
                    this.socket.emit('updateQuestion', { room: this.pollroomIdentifier, question: question});

                    console.log("Question updated");
                    this.initQuestion();
                    this.hideFullQuestion();
                },
                error => console.log(error, "Error")
            );
        }
    }

    questionVerifications() {
        let errorMessage: string;

        let answers: string[] = [];
        for (let answer of this.question.answers)
            if (answer.label && answer.label.trim())
                answers.push(answer.label.trim());

        if (answers.length < 2)
            errorMessage = "Min. 2 answers required";

        if (!(this.question.title && this.question.title.trim()))
            errorMessage = "No title for your question";

        return {error_message: errorMessage, answers: answers};
    }

    editQuestion(question: Question) {
        this.socket.emit('editingQuestion', { room: this.pollroomIdentifier, question_id: question.id});
        this.originalQuestion = new Question(question.id, question.title);
        this.originalQuestion.clone(question);
        this.question = question;
        this.displayFullQuestion();
    }

    addAnswer() {
        let size = this.question.answers.length;

        if (size < this.MAX_ANSWER)
            this.question.addAnswer(new Answer(size+1, ''));
        else
            console.log("Max. " + this.MAX_ANSWER + " answers");
    }

    removeAnswer(answer: Answer) {
        if (this.question.answers.length > 2)
            this.question.removeAnswer(answer);
        else
            console.log("Min. " + this.MIN_ANSWER + " answers");
    }

    displayFullQuestion() {
        this.isFocus = true;
    }

    hideFullQuestion() {
        this.isFocus = false;
    }

    displayOrHideFullQuestion() {
        this.isFocus = !this.isFocus;
        if (this.question.status === 'pending') {
            this.question.id = this.originalQuestion.id;
            this.question.title = this.originalQuestion.title;
            this.question.answers = [];
            this.originalQuestion.answers.forEach(ans => {
                let a = new Answer(ans.id, ans.label);
                a.is_answered = ans.is_answered;
                a.nb_responses = ans.nb_responses;
                a.letter = ans.letter;
                this.question.answers.push(a);
            });
            this.question.nb_participants = this.originalQuestion.nb_participants;
            this.question.nb_positives_votes = this.originalQuestion.nb_positives_votes;
            this.question.nb_negatives_votes = this.originalQuestion.nb_negatives_votes;

            this.question.status = this.originalQuestion.status;
            this.question.created_at = this.originalQuestion.created_at;

            this.socket.emit('abortEditingQuestion', { room: this.pollroomIdentifier, question_id: this.question.id });
            this.question.status = 'open';
            this.onUpdateCanceled.emit(this.question);
            this.initQuestion();
        }
    }

    initQuestion() {
        this.question = new Question(-1, '');
        this.question.addAnswer(new Answer(-1, ''));
        this.question.addAnswer(new Answer(-1, ''));
    }
}
