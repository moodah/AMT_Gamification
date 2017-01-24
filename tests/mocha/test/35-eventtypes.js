// Testing eventtypes/
// -------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('eventtypes/', function () {

    describe('POST', function () {
        
        it('should allow to create a new eventtype', function (done) {
            chai.request(CONFIG.API)
                .post('eventtypes/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    name: 'write_comment',
                    points: 10
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('body');
                    shared.eventtype = res.body;
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        it('should allow to create many eventtypes', function (done) {
            chai.request(CONFIG.API)
                .post('eventtypes/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    name: 'open_topic',
                    points: 20
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('body');
                    chai.expect(res.body).to.be.not.equal.to(shared.eventtype);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        // malformed payloads
        Utils.generateMalformed({
            name: 'name',
            points: 10829
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('eventtypes/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send(malformed)
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });
        });
    });

    describe('GET', function () {
        
        it('should return an array of created eventtypes', function (done) {
            chai.request(CONFIG.API)
                .get('eventtypes/')
                .set('autorization', shared.token)
                .then(function(res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('body');
                    chai.expect(res.body).to.have.lenght(2);
                    chai.expect(res.body[0].name).to.be.equal.to('write_comment');
                    chai.expect(res.body[0].points).to.be.equal.to(10);
                    chai.expect(res.body[1].name).to.be.equal.to('open_topic');
                    chai.expect(res.body[1].points).to.be.equal.to(20);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });
    });

    describe('eventtypes/{id}/', function () {
        
        describe('GET', function () {
            
            it('should return a specifiy eventtype', function (done) {
                chai.request(CONFIG.API)
                    .get('eventtypes/' + shared.eventtype.id + '/')
                    .set('autorization', shared.token)
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('body');
                        chai.expect(res.body.name).to.be.equal.to('write_comment');
                        chai.expect(res.body.points).to.be.equal.to(10);
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('eventtypes/7834/')
                    .set('autorization', shared.token)
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });

        describe('PATCH', function () {

            it('should allow to modify a specific eventtype', function (done) {
                chai.request(CONFIG.API)
                    .patch('eventtypes/' + shared.eventtype.id + '/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'comment',
                        points: 5
                    })
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('body');
                        chai.expect(res.body.name).to.be.equal.to('comment');
                        chai.expect(res.body.points).to.be.equal.to(5);
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .patch('eventtypes/404/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'should not work',
                        points: 9823
                    })
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });
    });
});