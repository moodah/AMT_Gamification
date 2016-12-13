// Testing the '/applications' endpoint:

let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let assert = chai.assert;
let should = chai.should();
let CONFIG = require('./config');

describe('/applications endpoint', function () {

    it('should allow to register a new application', function (done) {
        
    });

    it('should not allow to register two applications with the same name', function (done) {
        
    });

    describe('/applications/auth endpoint', function () {
        
        it('should returns the token for the application', function (done) {
            
        });

        it('should returns an error with bad credentials', function (done) {
            
        });
    });

    after(function (done) {
        
        // cleanup

    });
});