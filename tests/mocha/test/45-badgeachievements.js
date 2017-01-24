// Testing badgeachievements/
// --------------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('badgeachievements/', function () {

    describe('POST', function () {
        
        it('should allow to create a new badgeachievement', function (done) {
            chai.request(CONFIG.API)
                .post('badgeachievements/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    achievement_id: shared.achievement.id,
                    badge_id: shared.badge.id
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('body');
                    shared.badgeachievement = res.body;
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        it('should not allow to create two badgeachievements with the same IDs', function (done) {
            chai.request(CONFIG.API)
                .post('badgeachievements/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    achievement_id: shared.achievement.id,
                    badge_id: shared.badge.id
                })
                .end(function(err, res) {
                    chai.expect(err).to.not.be.undefined;
                    chai.expect(err).to.have.status(409);
                    done();
                });
        });

        it('should not allow an invalid achievement_id', function (done) {
            chai.request(CONFIG.API)
                .post('badgeachievements/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    achievement_id: 98283,
                    badge_id: shared.badge.id
                })
                .end(function(err, res) {
                    chai.expect(err).to.not.be.undefined;
                    chai.expect(err).to.have.status(400);
                    done();
                });
        });

        it('should not allow an invalid badge_id', function (done) {
            chai.request(CONFIG.API)
                .post('badgeachievements/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    achievement_id: shared.achievement.id,
                    badge_id: 3209
                })
                .end(function(err, res) {
                    chai.expect(err).to.not.be.undefined;
                    chai.expect(err).to.have.status(400);
                    done();
                });
        });

        // malformed payloads
        Utils.generateMalformed({
            achievement_id: 0,
            badge_id: 0
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('badgeachievements/')
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
        
        it('should return an array of created badgeachievements', function (done) {
            chai.request(CONFIG.API)
                .get('badgeachievements/')
                .set('autorization', shared.token)
                .then(function(res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('body');
                    chai.expect(res.body).to.have.lenght(1);
                    chai.expect(res.body[0].achievement_id).to.be.equal.to(shared.achievement.id);
                    chai.expect(res.body[0].badge_id).to.be.equal.to(shared.badge.id);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });
    });

    describe('badgeachievements/{id}/', function () {
        
        describe('GET', function () {
            
            it('should return a specifiy badgeachievement', function (done) {
                chai.request(CONFIG.API)
                    .get('badgeachievements/' + shared.badgeachievement.id + '/')
                    .set('autorization', shared.token)
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('body');
                        chai.expect(res.body.achievement_id).to.be.equal.to(shared.achievement.id);
                        chai.expect(res.body.badge_id).to.be.equal.to(shared.badge.id);
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('badgeachievements/7834/')
                    .set('autorization', shared.token)
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });
    });
});