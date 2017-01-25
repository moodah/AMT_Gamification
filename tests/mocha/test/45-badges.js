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

    beforeEach(function() {
        if(shared.achievement.length < 2) 
            this.skip();
    });

    describe('POST', function () {
        
        it('should allow to create a new badge', function (done) {
            chai.request(CONFIG.API)
                .post('badges/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    name: 'writer',
                    description: 'post 1000 comments',
                    achievements: [shared.achievement[0].id]
                })
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('text');
                    shared.badge.push(JSON.parse(res.text));
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });

        it('should allow to create many badges', function (done) {
            chai.request(CONFIG.API)
                .post('badges/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    name: 'noob',
                    description: 'open 100 topics',
                    achievements: [shared.achievement[1].id]
                })
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.not.equal(shared.badge[0]);
                    shared.badge.push(JSON.parse(res.text));
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });

        it('should not allow to create a badge with no achievement', function (done) {
            chai.request(CONFIG.API)
                .post('badges/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    name: 'klasjldsa',
                    description: 'should. not pass',
                    achievements: []
                })
                .end(function(err, res) {
                    Utils.debug('err', err);
                    chai.expect(err).to.not.be.null;
                    chai.expect(err).to.have.status(400);
                    done();
                });
        });

        // malformed payloads
        Utils.generateMalformed({
            name: 'name',
            description: 'description',
            achievements: [shared.achievement.id]
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('badges/')
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
            if(shared.badge.length < 2) 
                this.skip();
        });
        
        it('should return an array of created badges', function (done) {
            chai.request(CONFIG.API)
                .get('badges/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.have.lengthOf(2);
                    chai.expect(JSON.parse(res.text)[0].name).to.equal('writer');
                    chai.expect(JSON.parse(res.text)[0].description).to.equal('post 1000 comments');
                    chai.expect(JSON.parse(res.text)[0].achievements).to.have.lengthOf(1);
                    chai.expect(JSON.parse(res.text)[0].achievements[0]).to.equal(shared.achievement[0].id);
                    chai.expect(JSON.parse(res.text)[1].name).to.equal('noob');
                    chai.expect(JSON.parse(res.text)[1].description).to.equal('open 100 topics');
                    chai.expect(JSON.parse(res.text)[1].achievements).to.have.lengthOf(1);
                    chai.expect(JSON.parse(res.text)[1].achievements[0]).to.equal(shared.achievement[1].id);
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });
    });

    describe('badges/{id}/', function () {

        beforeEach(function() {
            if(shared.badge.length < 2) 
                this.skip();
        });
        
        describe('GET', function () {
            
            it('should return a specifiy badge', function (done) {
                chai.request(CONFIG.API)
                    .get('badges/' + shared.badge[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).name).to.equal('writer');
                        chai.expect(JSON.parse(res.text).description).to.equal('post 1000 comments');
                        chai.expect(JSON.parse(res.text).achievements).to.have.lengthOf(1);
                        chai.expect(JSON.parse(res.text).achievements[0]).to.equal(shared.achievement[0].id);
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('badges/7834/')
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

            it('should allow to modify a specific badge', function (done) {
                chai.request(CONFIG.API)
                    .patch('badges/' + shared.badge[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'super-writer',
                        description: 'post 10000 comments',
                        achievements: [shared.achievement[0].id]
                    })
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).name).to.equal('super-writer');
                        chai.expect(JSON.parse(res.text).description).to.equal('post 10000 comments');
                        chai.expect(JSON.parse(res.text).achievements).to.have.lengthOf(1);
                        chai.expect(JSON.parse(res.text).achievements[0]).to.equal(shared.achievement[0].id);
                        shared.badge[0] = JSON.parse(res.text);
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow to modify a specific badge in order to have badges with same names (badge names are unique for a given application)', function (done) {
                chai.request(CONFIG.API)
                    .patch('badges/' + shared.badge[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'noob'
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
                    .patch('badges/404/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'should not work',
                        description: 'definitively'
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