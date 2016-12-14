// Testing applications/
// ---------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');

describe('applications/', function () {

    describe('POST', function () {

        it('should allow to register a new application', function (done) {
            chai.request(CONFIG.API)
                .post('applications/')
                .set('content-type', 'application/json')
                .send({
                    name: 'testapplicationname',
                    password: '0123456789'
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
                    name: 'testapplicationname',
                    password: 'abcdefghijklmnopqrstuvwxyz'
                })
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(403);
                    done();
                })
                .catch(function (err) {
                    done(err);
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
                        name: 'testapplicationname',
                        password: '0123456789'
                    })
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res.body).to.have.property('token');
                        CONFIG.token = res.body.token;
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
                        name: 'testapplicationname923804',
                        password: '0123456789'
                    })
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(403);
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });

            it('should return an error with bad credentials (bad password)', function (done) {
                chai.request(CONFIG.API)
                    .post('applications/auth/')
                    .set('content-type', 'application/json')
                    .send({
                        name: 'testapplicationname',
                        password: '1234567890'
                    })
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(403);
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });
        });
    }); 
});

describe('CONFIG', function () {
            
    it('should have a valid token to continue tests', function (done) {
        chai.assert.notEqual(CONFIG.token, null);
        done();
    });
});