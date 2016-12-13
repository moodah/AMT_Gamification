// Testing applications/
// ---------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');

describe('POST on: applications/', function () {

    // the test application JWT 
    let token = null;

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

    describe('POST on: applications/auth/', function () {
        
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
                    token = res.body.token;
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

        // needs the token, thus we put this spec in a nested suite
        describe('DELETE on: applications/', function () {
            
            it('should allow to delete an application', function (done) {
                chai.assert.notEqual(token, null);
                chai.request(CONFIG.API)
                    .delete('application/')
                    .set('content-type', 'application/json')
                    .set('authorisation', token)
                    .send({
                        name: 'testapplicationname'
                    })
                    .then(function (res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        done();
                    })
                    .catch(function (err) {
                        done(err);
                    });
            });
        });
    });
});