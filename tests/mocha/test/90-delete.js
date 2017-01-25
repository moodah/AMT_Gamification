// Testing DELETE verb
// -------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('badges/', function () {

    describe('badges/{id}', function () {

        beforeEach(function() {
            if(shared.badge.length < 2) 
                this.skip();
        });

        describe('DELETE', function () {
                        
            it('should allow to delete a specific badge', function (done) {
                chai.request(CONFIG.API)
                    .delete('badges/' + shared.badge[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function(err) { 
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('badges/404/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
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
                
        it('should allow to delete all badges', function (done) {
            chai.request(CONFIG.API)
                .delete('badges/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function(err) { 
                    Utils.debug('err', err);
                    done(err);
                });
        });
    });
});

describe('achievements/', function () {

    describe('achievements/{id}', function () {

        beforeEach(function() {
            if(shared.achievement.length < 2) 
                this.skip();
        });

        describe('DELETE', function () {
                        
            it('should allow to delete a specific achievement', function (done) {
                chai.request(CONFIG.API)
                    .delete('achievements/' + shared.achievement[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function(err) { 
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('achievements/404/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
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
                
        it('should allow to delete all achievements', function (done) {
            chai.request(CONFIG.API)
                .delete('achievements/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function(err) { 
                    Utils.debug('err', err);
                    done(err);
                });
        });
    });
});

describe('eventtypes/', function () {

    describe('eventtypes/{id}', function () {

        beforeEach(function() {
            if(shared.eventtype.length < 2) 
                this.skip();
        });

        describe('DELETE', function () {
                        
            it('should allow to delete a specific eventtype', function (done) {
                chai.request(CONFIG.API)
                    .delete('eventtypes/' + shared.eventtype[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function(err) { 
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('eventtypes/404/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
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
                
        it('should allow to delete all eventtypes', function (done) {
            chai.request(CONFIG.API)
                .delete('eventtypes/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function(err) { 
                    Utils.debug('err', err);
                    done(err);
                });
        });
    });
});

describe('levels/', function () {

    describe('levels/{id}', function () {

        beforeEach(function() {
            if(shared.level.length < 2) 
                this.skip();
        });

        describe('DELETE', function () {
                        
            it('should allow to delete a specific level', function (done) {
                chai.request(CONFIG.API)
                    .delete('levels/' + shared.level[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function(err) { 
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('levels/404/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
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
                
        it('should allow to delete all levels', function (done) {
            chai.request(CONFIG.API)
                .delete('levels/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function(err) { 
                    Utils.debug('err', err);
                    done(err);
                });
        });
    });
});

describe('applications/', function () {

    describe('DELETE', function () {
            
        it('should allow to delete an application', function (done) {
            chai.request(CONFIG.API)
                .delete('applications/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function(err) { 
                    Utils.debug('err', err);
                    done(err);
                });
        });
    });
});