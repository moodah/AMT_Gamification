// Testing security of token
// -------------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

// Dynamically generated tests
describe('SECURITY', function () {

    // Here comes the request that need a valid token
    let TESTS = [
        { endpoint: 'applications/', verbs: ['DELETE'], payload: { name: 'kjdfbskfjdsf', password: '8932792341' } },
        { endpoint: 'levels/', verbs: ['GET', 'POST', 'DELETE'], payload: { name: 'qoiwqwq', points: 2389 } },
        { endpoint: 'levels/0/', verbs: ['GET', 'PATCH', 'DELETE'], payload: { name: 'dshfjks', points: 819 } },
        { endpoint: 'badges/', verbs: ['GET', 'POST', 'DELETE'], payload: { name: 'sakjn', description: 'lkjsaodiqjw' } },
        { endpoint: 'badges/0/', verbs: ['GET', 'PATCH', 'DELETE'], payload: { name: 'kdsajnc', description: 'qwlkd' } },
        { endpoint: 'eventtypes/', verbs: ['GET', 'POST', 'DELETE'], payload: { name: 'oiedjoqw', points: 120 } },
        { endpoint: 'eventtypes/0/', verbs: ['GET', 'PATCH', 'DELETE'], payload: { name: 'kjdscnla', points: 102 } },
        { endpoint: 'achievements/', verbs: ['GET', 'POST', 'DELETE'], payload: { count: 821, eventtype_id: 0, name: 'kajdqw' } },
        { endpoint: 'achievements/0/', verbs: ['GET', 'PATCH', 'DELETE'], payload: { count: 292, eventtype_id: 0, name: 'salkd' } },
        { endpoint: 'badgeachievements/', verbs: ['GET', 'POST', 'DELETE'], payload: { achievement_id: 0, badge_id: 0 } },
        { endpoint: 'badgeachievements/0/', verbs: ['GET', 'DELETE'], payload: null },
        { endpoint: 'events/', verbs: ['POST'], payload: { user_id: 92, eventtype_id: 0 } },
        { endpoint: 'users/', verbs: ['GET'], payload: null },
        { endpoint: 'users/0/', verbs: ['GET'], payload: null },
        { endpoint: 'leaderboards/', verbs: ['GET'], payload: null }
    ];

    // All requests are the same
    let REQUESTS = {
        'GET': function(endpoint, token, done, payload) {
            let r = chai.request(CONFIG.API)
                .get(endpoint)
                .set('content-type', 'application/json');
            if(token != null)
                r.set('authorization', token);
            r.end(function(err, res) { 
                Utils.debug('err', err);
                chai.expect(err).to.not.be.undefined;
                chai.expect(err).to.have.status(403);
                done();
            });
        },
        'POST': function(endpoint, token, done, payload) {        
            let r = chai.request(CONFIG.API)
                .post(endpoint)
                .set('content-type', 'application/json');
            if(token != null)
                r.set('authorization', token);
            r.send(payload);
            r.end(function(err, res) { 
                Utils.debug('err', err);
                chai.expect(err).to.not.be.undefined;
                chai.expect(err).to.have.status(403);
                done();
            });
        },
        'PATCH': function(endpoint, token, done, payload) {
            let r = chai.request(CONFIG.API)
                .patch(endpoint)
                .set('content-type', 'application/json');
            if(token != null)
                r.set('authorization', token);
            r.send(payload);
            r.end(function(err, res) { 
                Utils.debug('err', err);
                chai.expect(err).to.not.be.undefined;
                chai.expect(err).to.have.status(403);
                done();
            });
        },
        'DELETE': function(endpoint, token, done, payload) {        
            let r = chai.request(CONFIG.API)
                .delete(endpoint)
                .set('content-type', 'application/json');
            if(token != null)
                r.set('authorization', token);
            r.end(function(err, res) { 
                Utils.debug('err', err);
                chai.expect(err).to.not.be.undefined;
                chai.expect(err).to.have.status(403);
                done();
            });
        }
    };
    
    // loop
    TESTS.forEach(function (TEST) {

        describe(TEST.endpoint, function () {
            
            TEST.verbs.forEach(function(verb) {

                describe(verb, function () {
                    
                    it('should be forbidden with no token', function (done) {
                        REQUESTS[verb](TEST.endpoint, null, done, TEST.payload);
                    });

                    it('should be forbidden with bad token', function (done) {
                        let badToken = shared.token + '123';
                        REQUESTS[verb](TEST.endpoint, badToken, done, TEST.payload);
                    });
                });
            });
        });
    });
});