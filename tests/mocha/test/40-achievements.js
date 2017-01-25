// Testing achievements/
// ---------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('achievements/', function () {

    beforeEach(function() {
        if(shared.eventtype.length < 2) 
            this.skip();
    });

    describe('POST', function () {
        
        it('should allow to create a new achievement', function (done) {
            chai.request(CONFIG.API)
                .post('achievements/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    count: 10,
                    eventtype_id: shared.eventtype[0].id,
                    name: 'wow'
                })
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('text');
                    shared.achievement.push(JSON.parse(res.text));
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });

        it('should allow to create many achievements', function (done) {
            chai.request(CONFIG.API)
                .post('achievements/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    count: 20,
                    eventtype_id: shared.eventtype[1].id,
                    name: 'omg'
                })
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.not.equal(shared.achievement[0]);
                    shared.achievement.push(JSON.parse(res.text));
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });

        it('should not allow an invalid eventtype_id', function (done) {
            chai.request(CONFIG.API)
                .post('achievements/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    count: 30,
                    eventtype_id: 2983,
                    name: 'invalid'
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
            count: 0,
            eventtype_id: 0,
            name: ''
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('achievements/')
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
            if(shared.achievement.length < 2) 
                this.skip();
        });
        
        it('should return an array of created achievements', function (done) {
            chai.request(CONFIG.API)
                .get('achievements/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.have.lengthOf(2);
                    chai.expect(JSON.parse(res.text)[0].count).to.equal(10);
                    chai.expect(JSON.parse(res.text)[0].eventtype_id).to.equal(shared.eventtype[0].id);
                    chai.expect(JSON.parse(res.text)[0].name).to.equal('wow');
                    chai.expect(JSON.parse(res.text)[1].count).to.equal(20);
                    chai.expect(JSON.parse(res.text)[1].eventtype_id).to.equal(shared.eventtype[1].id);
                    chai.expect(JSON.parse(res.text)[1].name).to.equal('omg');
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });
    });

    describe('achievements/{id}/', function () {

        beforeEach(function() {
            if(shared.achievement.length < 2) 
                this.skip();
        });
        
        describe('GET', function () {
            
            it('should return a specifiy achievement', function (done) {
                chai.request(CONFIG.API)
                    .get('achievements/' + shared.achievement[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).count).to.equal(10);
                        chai.expect(JSON.parse(res.text).eventtype_id).to.equal(shared.eventtype[0].id);
                        chai.expect(JSON.parse(res.text).name).to.equal('wow');
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('achievements/7834/')
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

            it('should allow to modify a specific achievement', function (done) {
                chai.request(CONFIG.API)
                    .patch('achievements/' + shared.achievement[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        count: 50,
                        eventtype_id: shared.eventtype[0].id,
                        name: 'amazing'
                    })
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).count).to.equal(50);
                        chai.expect(JSON.parse(res.text).eventtype_id).to.equal(shared.eventtype[0].id);
                        chai.expect(JSON.parse(res.text).name).to.equal('amazing');
                        shared.achievement[0] = JSON.parse(res.text);
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .patch('achievements/404/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'should not work',
                        points: 9823
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