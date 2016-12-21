// Testing applications/
// ---------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('applications/', function () {

    describe('POST', function () {

        it('should allow to register a new application', function (done) {
            chai.request(CONFIG.API)
                .post('applications/')
                .set('content-type', 'application/json')
                .send({
                    name: CONFIG.APPNAME,
                    password: CONFIG.APPPWD
                })
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });

        it('should not allow to register two applications with the same name', function (done) {
            chai.request(CONFIG.API)
                .post('applications/')
                .set('content-type', 'application/json')
                .send({
                    name: CONFIG.APPNAME,
                    password: CONFIG.APPPWD + '_'
                })
                .end(function (err, res) {
                    chai.expect(err).to.not.be.undefined;
                    chai.expect(err).to.have.status(409);
                    done();
                });
        });

        // malformed payloads
        Utils.generateMalformed({
            name: CONFIG.APPNAME,
            password: CONFIG.APPPWD
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('applications/')
                    .set('content-type', 'application/json')
                    .send(malformed.payload)
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });
        });

        it('should refuse when application\'s name is empty', function (done) {
            chai.request(CONFIG.API)
                .post('applications/')
                .set('content-type', 'application/json')
                .send({
                    name: '',
                    password: CONFIG.APPPWD 
                })
                .end(function (err, res) {
                    chai.expect(err).to.not.be.undefined;
                    chai.expect(err).to.have.status(400);
                    done();
                });
        });

        it('should refuse when application\'s password is smaller than 8 chars', function (done) {
            chai.request(CONFIG.API)
                .post('applications/')
                .set('content-type', 'application/json')
                .send({
                    name: CONFIG.APPNAME + '433423',
                    password: '1234567'
                })
                .end(function (err, res) {
                    chai.expect(err).to.not.be.undefined;
                    chai.expect(err).to.have.status(400);
                    done();
                });
        });
    });

    describe('applications/auth/', function () {

        describe('POST', function () {
        
            it('should return the token for the application', function (done) {
                chai.request(CONFIG.API)
                    .post('applications/auth/')
                    .set('content-type', 'application/json')
                    .send({
                        name: CONFIG.APPNAME,
                        password: CONFIG.APPPWD
                    })
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(201);
                        chai.expect(res.body).to.have.property('token');
                        shared.token = res.body.token;
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });

            it('should return an error with bad credentials (bad name)', function (done) {
                chai.request(CONFIG.API)
                    .post('applications/auth/')
                    .set('content-type', 'application/json')
                    .send({
                        name: CONFIG.APPNAME + '_',
                        password: CONFIG.APPPWD
                    })
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });

            it('should return an error with bad credentials (bad password)', function (done) {
                chai.request(CONFIG.API)
                    .post('applications/auth/')
                    .set('content-type', 'application/json')
                    .send({
                        name: CONFIG.APPNAME,
                        password: CONFIG.APPPWD + '_'
                    })
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });

            // malformed payloads
            Utils.generateMalformed({
                name: CONFIG.APPNAME,
                password: CONFIG.APPPWD
            }).forEach(function(malformed) {

                it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                    chai.request(CONFIG.API)
                        .post('applications/auth/')
                        .set('content-type', 'application/json')
                        .send(malformed.payload)
                        .end(function (err, res) {
                            chai.expect(err).to.not.be.undefined;
                            chai.expect(err).to.have.status(400);
                            done();
                        });
                });
            });

            it('should refuse when application\'s name is empty', function (done) {
                chai.request(CONFIG.API)
                    .post('applications/auth/')
                    .set('content-type', 'application/json')
                    .send({
                        name: '',
                        password: CONFIG.APPPWD 
                    })
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });

            it('should refuse when application\'s password is smaller than 8 chars', function (done) {
                chai.request(CONFIG.API)
                    .post('applications/auth/')
                    .set('content-type', 'application/json')
                    .send({
                        name: CONFIG.APPNAME + '2873298379',
                        password: '1234567' 
                    })
                    .end(function (err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });
        });
    }); 
});
