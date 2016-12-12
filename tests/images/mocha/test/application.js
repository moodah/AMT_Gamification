// Testing the '/applications' endpoint:

var chai = require('chai');
var chaiHttp = require('chai-http');
chai.use(chaiHttp);
var assert = chai.assert;
var should = chai.should();

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
});