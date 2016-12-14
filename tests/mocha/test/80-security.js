// Testing security of token
// -------------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');

// Here comes the request that need a valid token
let TESTS = [
    { endpoint: 'applications/', verbs: ['DELETE'] },
    { endpoint: 'levels/', verbs: ['GET', 'POST', 'DELETE'] },
    { endpoint: 'levels/{id}', verbs: ['GET', 'PATCH', 'DELETE'] },
    { endpoint: 'badges/', verbs: ['GET', 'POST', 'DELETE'] },
    { endpoint: 'badges/{id}', verbs: ['GET', 'PATCH', 'DELETE'] },
    { endpoint: 'rules/', verbs: ['GET', 'POST', 'DELETE'] },
    { endpoint: 'rules/{id}', verbs: ['GET', 'PATCH', 'DELETE'] },
    { endpoint: 'events/', verbs: ['POST'] },
    { endpoint: 'users/', verbs: ['GET'] },
    { endpoint: 'users/{id}', verbs: ['GET'] },
    { endpoint: 'leaderboards/', verbs: ['GET'] }
];

// dynamically generated tests
describe('SECURITY', function () {
    
    TESTS.forEach(function (TEST) {

        describe(TEST.endpoint, function () {
            
            TEST.verbs.forEach(function(verb) {

                describe(verb, function () {
                    
                    it('should be forbidden with no token', function (done) {
                        this.skip();
                    });

                    it('should be forbidden with bad token', function (done) {
                        this.skip();
                    });
                });
            });
        });
    });
});