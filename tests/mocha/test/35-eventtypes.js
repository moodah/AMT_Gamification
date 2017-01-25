// Testing eventtypes/
// -------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('eventtypes/', function () {

    describe('POST', function () {
        
        it('should allow to create a new eventtype', function (done) {
            chai.request(CONFIG.API)
                .post('eventtypes/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    name: 'write_comment',
                    points: 10
                })
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('text');
                    shared.eventtype.push(JSON.parse(res.text));
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });

        it('should allow to create many eventtypes', function (done) {
            chai.request(CONFIG.API)
                .post('eventtypes/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .send({
                    name: 'open_topic',
                    points: 20
                })
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.not.equal(shared.eventtype[0]);
                    shared.eventtype.push(JSON.parse(res.text));
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });

        // malformed payloads
        Utils.generateMalformed({
            name: 'name',
            points: 10829
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('eventtypes/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send(malformed)
                    .end(function(err, res) { 
                        Utils.debug('err', err);
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });
        });
    });

    describe('GET', function () {

        beforeEach(function() {
            if(shared.eventtype.length < 2) 
                this.skip();
        });
        
        it('should return an array of created eventtypes', function (done) {
            chai.request(CONFIG.API)
                .get('eventtypes/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.have.lenght(2);
                    chai.expect(JSON.parse(res.text)[0].name).to.be.equal.to('write_comment');
                    chai.expect(JSON.parse(res.text)[0].points).to.be.equal.to(10);
                    chai.expect(JSON.parse(res.text)[1].name).to.be.equal.to('open_topic');
                    chai.expect(JSON.parse(res.text)[1].points).to.be.equal.to(20);
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
                    done(err);
                });
        });
    });

    describe('eventtypes/{id}/', function () {

        beforeEach(function() {
            if(shared.eventtype.length < 2) 
                this.skip();
        });
        
        describe('GET', function () {
            
            it('should return a specifiy eventtype', function (done) {
                chai.request(CONFIG.API)
                    .get('eventtypes/' + shared.eventtype[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).name).to.be.equal.to('write_comment');
                        chai.expect(JSON.parse(res.text).points).to.be.equal.to(10);
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('eventtypes/7834/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .end(function(err, res) { 
                        Utils.debug('err', err);
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });

        describe('PATCH', function () {

            it('should allow to modify a specific eventtype', function (done) {
                chai.request(CONFIG.API)
                    .patch('eventtypes/' + shared.eventtype[0].id + '/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'comment',
                        points: 5
                    })
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).name).to.be.equal.to('comment');
                        chai.expect(JSON.parse(res.text).points).to.be.equal.to(5);
                        shared.eventtype[0] = JSON.parse(res.text);
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .patch('eventtypes/404/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .send({
                        name: 'should not work',
                        points: 9823
                    })
                    .end(function(err, res) { 
                        Utils.debug('err', err);
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });
    });
});