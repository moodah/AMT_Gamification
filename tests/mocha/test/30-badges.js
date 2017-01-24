// Testing badges/
// ---------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('badges/', function () {

    describe('POST', function () {
        
        it('should allow to create a new badge', function (done) {
            chai.request(CONFIG.API)
                .post('badges/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    name: 'writer',
                    description: 'post 1000 comments'
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res.body).to.have.property('url');
                    shared.badge = res.body.url;
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        it('should allow to create many badges', function (done) {
            chai.request(CONFIG.API)
                .post('badges/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    name: 'noob',
                    description: 'open 100 topics'
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res.body).to.have.property('url');
                    chai.expect(res.body.url).to.be.not.equal.to(shared.badge);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        // malformed payloads
        Utils.generateMalformed({
            name: 'name',
            description: 'description'
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('badges/')
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
        
        it('should return an array of created badges', function (done) {
            chai.request(CONFIG.API)
                .get('badges/')
                .set('autorization', shared.token)
                .then(function(res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res.body).to.have.property('badges');
                    chai.expect(res.body.badges).to.have.lenght(2);
                    chai.expect(res.body.badges[0]).to.be.equal.to({
                        name: 'writer',
                        description: 'post 1000 comments'
                    });
                    chai.expect(res.body.badges[1]).to.be.equal.to({
                        name: 'noob',
                        description: 'open 100 topics'
                    });
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });
    });

    describe('badges/{id}/', function () {
        
        describe('GET', function () {
            
            it('should return a specifiy badge (' + shared.badge + ')', function (done) {
                chai.request(CONFIG.API)
                    .get(shared.badge)
                    .set('autorization', shared.token)
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res.body).to.have.property('badge');
                        chai.expect(res.body.badge).to.be.equal.to({
                            name: 'writer',
                            description: 'post 1000 comments'
                        });
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('badges/7834/')
                    .set('autorization', shared.token)
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });

        describe('PATCH', function () {

            it('should allow to modify a specific badge', function (done) {
                chai.request(CONFIG.API)
                    .patch(shared.badge)
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'super-writer',
                        description: 'post 10000 comments'
                    })
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res.body).to.have.property('badge');
                        chai.expect(res.body.badge).to.be.equal.to({
                            name: 'super-writer',
                            description: 'post 10000 comments'
                        });
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow to modify a specific badge in order to have badges with same names (badge names are unique for a given application)', function (done) {
                chai.request(CONFIG.API)
                    .patch(shared.badge)
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'noob'
                    })
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .patch('badges/404/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'should not work',
                        description: 'definitively'
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