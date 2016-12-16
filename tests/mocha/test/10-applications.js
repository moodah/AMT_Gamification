// Testing applications/
// ---------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');

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
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(403);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });

        it('should refuse a malformed payload', function (done) {
            this.skip();
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
                        chai.expect(res).to.have.status(200);
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
                        name: CONFIG.APPNAME,
                        password: CONFIG.APPPWD + '_'
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

            it('should refuse a malformed payload', function (done) {
                this.skip();
            });
        });
    }); 
});
