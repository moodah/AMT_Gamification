// Testing isolation of applications
// ---------------------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('ISOLATION', function () {

    // temporary application token
    let tmptoken = null;

    // get the token
    before(function (done) {
        this.timeout(0);
        chai.request(CONFIG.API)
            .post('applications/')
            .set('content-type', 'application/json')
            .send({
                name: '__tempapp32190s38',
                password: '23891ldas'
            })
            .then(function(res) {
                chai.request(CONFIG.API)
                    .post('applications/auth/')
                    .set('content-type', 'application/json')
                    .send({
                        name: '__tempapp32190s38',
                        password: '23891ldas'
                    })
                    .then(function(res) {
                        tmptoken = res.body.token;
                        Utils.debug('tmptoken', tmptoken);
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            })
            .catch(function(err) {
                Utils.debug('err', err);
                done(err);
            });
    });

    // cleanup
    after(function (done) {
        chai.request(CONFIG.API)
            .delete('applications/')
            .set('content-type', 'application/json')
            .set('authorization', tmptoken)
            .then(function(res) {
                done();
            })
            .catch(function(err) {
                Utils.debug('err', err);
            });
    });

    beforeEach(function () {
        if(shared.level.length < 2
            || shared.badge.length < 2
            || shared.eventtype.length < 2
            || shared.achievement.length < 2) 
            this.skip();
    });

    describe('between applications', function () {
        
        describe('GET', function () {

            describe('levels/{id}/', function () {
                
                it('should not be able to access an other application level', function (done) {
                    chai.request(CONFIG.API)
                        .get('levels/' + shared.level[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });

            describe('badges/{id}/', function () {
                                
                it('should not be able to access an other application badge', function (done) {
                    chai.request(CONFIG.API)
                        .get('badges/' + shared.badge[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });
            
            describe('eventtypes/{id}/', function () {
                                
                it('should not be able to access an other application eventtype', function (done) {
                    chai.request(CONFIG.API)
                        .get('eventtypes/' + shared.eventtype[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });

            describe('achievements/{id}/', function () {
                                
                it('should not be able to access an other application achievement', function (done) {
                    chai.request(CONFIG.API)
                        .get('achievements/' + shared.achievement[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });
        });

        describe('POST', function () {
            
            describe('achievements/', function () {

                it('should not be able to use an other application eventtype_id', function (done) {
                    chai.request(CONFIG.API)
                        .post('achievements/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .send({
                            count: 1000,
                            eventtype_id: shared.eventtype[0].id,
                            name: '!!!'
                        })
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(400);
                            done();
                        });
                }); 
            });

            describe('badges/', function () {

                it('should not be able to use an other application achievement_id', function (done) {
                    chai.request(CONFIG.API)
                        .post('badges/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .send({
                            name: 'should',
                            description: 'not work',
                            achievements: [shared.achievement[0].id]
                        })
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(400);
                            done();
                        });
                }); 
            });
        });

        describe('PATCH', function () {
            
            describe('levels/{id}/', function () {
                
                it('should not be able to patch an other application level', function (done) {
                    chai.request(CONFIG.API)
                        .patch('levels/' + shared.level[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .send({
                            name: 'should not work',
                            points: 42
                        })
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });

            describe('badges/{id}/', function () {
                
                it('should not be able to patch an other application badge', function (done) {
                    chai.request(CONFIG.API)
                        .patch('badges/' + shared.badge[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .send({
                            name: 'should not work',
                            description: 'absolutely',
                            achievements: [shared.achievement[0].id]
                        })
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });
            
            describe('eventtypes/{id}/', function () {
                
                it('should not be able to patch an other application eventtype', function (done) {
                    chai.request(CONFIG.API)
                        .patch('eventtypes/' + shared.eventtype[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .send({
                            name: 'should not work',
                            points: 42
                        })
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });

            describe('achievements/{id}/', function () {
                
                it('should not be able to patch an other application achievement', function (done) {
                    chai.request(CONFIG.API)
                        .patch('achievements/' + shared.achievement[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .send({
                            count: 897,
                            eventtype_id: shared.eventtype[0].id,
                            name: 'kljlkj'
                        })
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });
        });

        describe('DELETE', function () {
            
            describe('levels/{id}/', function () {
                
                it('should not be able to delete an other application level', function (done) {
                    chai.request(CONFIG.API)
                        .delete('levels/' + shared.level[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });

            describe('badges/{id}/', function () {
                
                it('should not be able to delete an other application badge', function (done) {
                    chai.request(CONFIG.API)
                        .delete('badges/' + shared.badge[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });
            
            describe('eventtypes/{id}/', function () {
                
                it('should not be able to delete an other application eventtype', function (done) {
                    chai.request(CONFIG.API)
                        .delete('eventtypes/' + shared.eventtype[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });

            describe('achievements/{id}/', function () {
                
                it('should not be able to delete an other application achievement', function (done) {
                    chai.request(CONFIG.API)
                        .delete('achievements/' + shared.achievement[0].id + '/')
                        .set('content-type', 'application/json')
                        .set('authorization', tmptoken)
                        .end(function(err, res) {
                            Utils.debug('err', err);
                            chai.expect(err).to.not.be.null;
                            chai.expect(err).to.have.status(404);
                            done();
                        });
                });
            });
        });
    });
});