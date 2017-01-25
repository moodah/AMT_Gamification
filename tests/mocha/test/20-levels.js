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
                .set('authorization', shared.token)
                .send({
                    name: 'rookie',
                    points: 10
                })
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('text');
                    shared.level.push(JSON.parse(res.text));
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });

        it('should allow to create many levels', function (done) {
            chai.request(CONFIG.API)
                .post('levels/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    name: 'pro',
                    points: 100
                })
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.not.equal(shared.level[0]);
                    shared.level.push(JSON.parse(res.text));
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
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
                    .set('authorization', shared.token)
                    .send(malformed)
                    .end(function(err, res) { 
                        Utils.debug('err', err);
                        chai.expect(err).to.not.be.null;
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
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.have.lengthOf(2);
                    chai.expect(JSON.parse(res.text)[0].name).to.equal('rookie');
                    chai.expect(JSON.parse(res.text)[0].points).to.equal(10);
                    chai.expect(JSON.parse(res.text)[1].name).to.equal('pro');
                    chai.expect(JSON.parse(res.text)[1].points).to.equal(100);
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
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
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).name).to.equal('rookie');
                        chai.expect(JSON.parse(res.text).points).to.equal(10);
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('levels/7834/')
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

        describe('PATCH', function () {

            it('should allow to modify a specific level', function (done) {
                chai.request(CONFIG.API)
                    .patch('levels/' + shared.level[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'semi-pro',
                        points: 15
                    })
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).name).to.equal('semi-pro');
                        chai.expect(JSON.parse(res.text).points).to.equal(15);
                        shared.level[0] = JSON.parse(res.text);
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow to modify a specific level in order to have levels with same names (level names are unique for a given application)', function (done) {
                chai.request(CONFIG.API)
                    .patch('levels/' + shared.level[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'pro'
                    })
                    .end(function(err, res) { 
                        Utils.debug('err', err);
                        chai.expect(err).to.not.be.null;
                        chai.expect(err).to.have.status(409);
                        done();
                    });
            });

            it('should not allow to modify a specific level in order to have levels with same points (level points are unique for a given application)', function (done) {
                chai.request(CONFIG.API)
                    .patch('levels/' + shared.level[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        points: 100
                    })
                    .end(function(err, res) { 
                        Utils.debug('err', err);
                        chai.expect(err).to.not.be.null;
                        chai.expect(err).to.have.status(409);
                        done();
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .patch('levels/404/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'should not work',
                        points: 404
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
});