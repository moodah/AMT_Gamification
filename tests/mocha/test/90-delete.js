// Testing DELETE verb
// -------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');

describe('badgeachievements/', function () {

    describe('badgeachievements/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific badgeachievement', function (done) {
                chai.request(CONFIG.API)
                    .delete('badgeachievements/' + shared.badgeachievement[0].id + '/')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('badgeachievements/404/')
                    .set('authorization', shared.token)
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });
    });

    describe('DELETE', function () {
                
        it('should allow to delete all badgeachievements', function (done) {
            chai.request(CONFIG.API)
                .delete('badgeachievements/')
                .set('authorization', shared.token)
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });
    });
});

describe('achievements/', function () {

    describe('achievements/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific achievement', function (done) {
                chai.request(CONFIG.API)
                    .delete('achievements/' + shared.achievement[0].id + '/')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('achievements/404/')
                    .set('authorization', shared.token)
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
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
                .set('authorization', shared.token)
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });
    });
});

describe('eventtypes/', function () {

    describe('eventtypes/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific eventtype', function (done) {
                chai.request(CONFIG.API)
                    .delete('eventtypes/' + shared.eventtype[0].id + '/')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('eventtypes/404/')
                    .set('authorization', shared.token)
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
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
                .set('authorization', shared.token)
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });
    });
});

describe('badges/', function () {

    describe('badges/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific badge', function (done) {
                chai.request(CONFIG.API)
                    .delete('badges/' + shared.badge[0].id + '/')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('badges/404/')
                    .set('authorization', shared.token)
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
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
                .set('authorization', shared.token)
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });
    });
});

describe('levels/', function () {

    describe('levels/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific level', function (done) {
                chai.request(CONFIG.API)
                    .delete('levels/' + shared.level[0].id + '/')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(204);
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .delete('levels/404/')
                    .set('authorization', shared.token)
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
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
                .set('authorization', shared.token)
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function (err) {
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
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });
    });
});