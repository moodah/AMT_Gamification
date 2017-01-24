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
        { endpoint: 'applications/', verbs: ['DELETE'] },
        { endpoint: 'levels/', verbs: ['GET', 'POST', 'DELETE'] },
        { endpoint: 'levels/0/', verbs: ['GET', 'PATCH', 'DELETE'] },
        { endpoint: 'badges/', verbs: ['GET', 'POST', 'DELETE'] },
        { endpoint: 'badges/0/', verbs: ['GET', 'PATCH', 'DELETE'] },
        { endpoint: 'eventtypes/', verbs: ['GET', 'POST', 'DELETE'] },
        { endpoint: 'eventtypes/0/', verbs: ['GET', 'PATCH', 'DELETE'] },
        { endpoint: 'achievements/', verbs: ['GET', 'POST', 'DELETE'] },
        { endpoint: 'achievements/0/', verbs: ['GET', 'PATCH', 'DELETE'] },
        { endpoint: 'badgeachievements/', verbs: ['GET', 'POST', 'DELETE'] },
        { endpoint: 'badgeachievements/0/', verbs: ['GET', 'DELETE'] },
        { endpoint: 'events/', verbs: ['POST'] },
        { endpoint: 'users/', verbs: ['GET'] },
        { endpoint: 'users/0/', verbs: ['GET'] },
        { endpoint: 'leaderboards/', verbs: ['GET'] }
    ];

    // All requests are the same
    let REQUESTS = {
        'GET': function(endpoint, token, done) {
            let r = chai.request(CONFIG.API)
                .get(endpoint)
                .set('content-type', 'application/json');
            if(token != null)
                r.set('authorization', token);
            r.end(function(err, res) { 
                Utils.debug(err);
                chai.expect(err).to.not.be.undefined;
                chai.expect(err).to.have.status(403);
                done();
            });
        },
        'POST': function(endpoint, token, done) {        
            let r = chai.request(CONFIG.API)
                .post(endpoint)
                .set('content-type', 'application/json');
            if(token != null)
                r.set('authorization', token);
            r.end(function(err, res) { 
                Utils.debug(err);
                chai.expect(err).to.not.be.undefined;
                chai.expect(err).to.have.status(403);
                done();
            });
        },
        'PATCH': function(endpoint, token, done) {
            let r = chai.request(CONFIG.API)
                .patch(endpoint)
                .set('content-type', 'application/json');
            if(token != null)
                r.set('authorization', token);
            r.end(function(err, res) { 
                Utils.debug(err);
                chai.expect(err).to.not.be.undefined;
                chai.expect(err).to.have.status(403);
                done();
            });
        },
        'DELETE': function(endpoint, token, done) {        
            let r = chai.request(CONFIG.API)
                .delete(endpoint)
                .set('content-type', 'application/json');
            if(token != null)
                r.set('authorization', token);
            r.end(function(err, res) { 
                Utils.debug(err);
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
                        REQUESTS[verb](TEST.endpoint, null, done);
                    });

                    it('should be forbidden with bad token', function (done) {
                        let badToken = shared.token + '123';
                        REQUESTS[verb](TEST.endpoint, badToken, done);
                    });
                });
            });
        });
    });
});