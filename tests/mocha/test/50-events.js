// Testing events/
// ---------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('events/', function () {

    beforeEach(function() {
        if(shared.eventtype.length < 2) 
            this.skip();
    });

    describe('POST', function () {
    
        it('should allow to submit a new event', function (done) {
            chai.request(CONFIG.API)
                .post('events/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    user_id: 0,
                    eventtype_id: shared.eventtype[0].id
                })
                .then(function(res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        it('should allow to submit many events', function (done) {
            chai.request(CONFIG.API)
                .post('events/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    user_id: 1,
                    eventtype_id: shared.eventtype[1].id
                })
                .then(function(res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(201);
                    done();
                })
                .catch(function(err) {
                    done(err);
                });
        });

        it('should not allow an invalid eventtype_id', function (done) {
            chai.request(CONFIG.API)
                .post('events/')
                .set('content-type', 'application/json')
                .set('autorization', shared.token)
                .send({
                    user_id: 0,
                    eventtype_id: 8293
                })
                .end(function(err, res) {
                    chai.expect(err).to.not.be.undefined;
                    chai.expect(err).to.have.status(400);
                    done();
                });
        });

        // malformed payloads
        Utils.generateMalformed({
            user_id: 0,
            eventtype_id: 0
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                chai.request(CONFIG.API)
                    .post('events/')
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
});