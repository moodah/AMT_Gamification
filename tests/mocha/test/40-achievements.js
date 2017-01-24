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

    describe('POST', function () {
        
        it('should allow to create a new achievement', function (done) {
            chai.request(CONFIG.API)
                .post('achievements/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    count: 10,
                    eventtype_id: shared.eventtype[0].id,
                    name: 'wow'
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('body');
                    shared.achievement.push(res.body);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        it('should allow to create many achievements', function (done) {
            chai.request(CONFIG.API)
                .post('achievements/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    count: 20,
                    eventtype_id: shared.eventtype[1].id,
                    name: 'omg'
                })
                .then(function(res) {
                    console.log('res: ' + JSON.stringify(res));
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    chai.expect(res).to.have.property('body');
                    chai.expect(res.body).to.be.not.equal.to(shared.achievement[0]);
                    shared.achievement.push(res.body);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        it('should not allow an invalid eventtype_id', function (done) {
            chai.request(CONFIG.API)
                .post('achievements/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    count: 30,
                    eventtype_id: 2983,
                    name: 'invalid'
                })
                .end(function(err, res) {
                    chai.expect(err).to.not.be.undefined;
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
        
        it('should return an array of created achievements', function (done) {
            chai.request(CONFIG.API)
                .get('achievements/')
                .set('autorization', shared.token)
                .then(function(res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('body');
                    chai.expect(res.body).to.have.lenght(2);
                    chai.expect(res.body[0].count).to.be.equal.to(10);
                    chai.expect(res.body[0].eventtype_id).to.be.equal.to(shared.eventtype[0].id);
                    chai.expect(res.body[0].name).to.be.equal.to('wow');
                    chai.expect(res.body[1].count).to.be.equal.to(20);
                    chai.expect(res.body[1].eventtype_id).to.be.equal.to(shared.eventtype[1].id);
                    chai.expect(res.body[1].name).to.be.equal.to('omg');
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });
    });

    describe('achievements/{id}/', function () {
        
        describe('GET', function () {
            
            it('should return a specifiy achievement', function (done) {
                chai.request(CONFIG.API)
                    .get('achievements/' + shared.achievement[0].id + '/')
                    .set('autorization', shared.token)
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('body');
                        chai.expect(res.body.count).to.be.equal.to(10);
                        chai.expect(res.body.eventtype_id).to.be.equal.to(shared.eventtype[0].id);
                        chai.expect(res.body.name).to.be.equal.to('wow');
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('achievements/7834/')
                    .set('autorization', shared.token)
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
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
                    .set('autorization', shared.token)
                    .send({
                        count: 50,
                        eventtype_id: shared.eventtype[0].id,
                        name: 'amazing'
                    })
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('body');
                        chai.expect(res.body.count).to.be.equal.to(50);
                        chai.expect(res.body.eventtype_id).to.be.equal.to(shared.eventtype[0].id);
                        chai.expect(res.body.name).to.be.equal.to('amazing');
                        shared.achievement[0] = res.body;
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .patch('achievements/404/')
                    .set('content-type', 'application/json')
                    .set('autorization', shared.token)
                    .send({
                        name: 'should not work',
                        points: 9823
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