// Testing levels/
// ---------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('levels/', function () {

    describe('POST', function () {
        
        it('should allow to create a new level', function (done) {
            chai.request(CONFIG.API)
                .post('levels/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    name: 'rookie',
                    points: 10
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('body');
                    shared.level.push(res.body);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        it('should allow to create many levels', function (done) {
            chai.request(CONFIG.API)
                .post('levels/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    name: 'pro',
                    points: 100
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('body');
                    chai.expect(res.body).to.be.not.equal.to(shared.level[0]);
                    shared.level.push(res.body);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        // malformed payloads
        Utils.generateMalformed({
            name: 'levelname',
            points: 234
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('levels/')
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

        beforeEach(function() {
            if(shared.level.length < 2) 
                this.skip();
        });
        
        it('should return an array of created levels', function (done) {
            chai.request(CONFIG.API)
                .get('levels/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .then(function(res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('body');
                    chai.expect(res.body).to.have.lenght(2);
                    chai.expect(res.body[0].name).to.be.equal.to('rookie');
                    chai.expect(res.body[0].points).to.be.equal.to(10);
                    chai.expect(res.body[1].name).to.be.equal.to('pro');
                    chai.expect(res.body[1].points).to.be.equal.to(100);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });
    });

    describe('levels/{id}/', function () {

        beforeEach(function() {
            if(shared.level.length < 2) 
                this.skip();
        });
        
        describe('GET', function () {
            
            it('should return a specifiy level', function (done) {
                chai.request(CONFIG.API)
                    .get('levels/' + shared.level[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('body');
                        chai.expect(res.body.name).to.be.equal.to('rookie');
                        chai.expect(res.body.points).to.be.equal.to(10);
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('levels/7834/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });

        describe('PATCH', function () {

            it('should allow to modify a specific level', function (done) {
                chai.request(CONFIG.API)
                    .patch('levels/' + shared.level[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'semi-pro',
                        points: 50
                    })
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('body');
                        chai.expect(res.body.name).to.be.equal.to('semi-pro');
                        chai.expect(res.body.points).to.be.equal.to(50);
                        shared.level[0] = res.body;
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow to modify a specific level in order to have levels with same names (level names are unique for a given application)', function (done) {
                chai.request(CONFIG.API)
                    .patch('levels/' + shared.level[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'pro'
                    })
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });

            it('should not allow to modify a specific level in order to have levels with same points (level points are unique for a given application)', function (done) {
                chai.request(CONFIG.API)
                    .patch('levels/' + shared.level[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        points: 100
                    })
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .patch('levels/404/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'should not work',
                        points: 404
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