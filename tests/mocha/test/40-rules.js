// Testing rules/
// --------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');

describe('rules/', function () {

    describe('POST', function () {
        
        it('should allow to create a new rule', function (done) {
            this.skip();
        });

        it('should allow to create many rules', function (done) {
            this.skip();
        });

        it('should refuse a malformed payload', function (done) {
            this.skip();
        });
    });

    describe('GET', function () {
        
        it('should return an array of created rules', function (done) {
            this.skip();
        });
    });

    describe('rules/{id}', function () {
        
        describe('GET', function () {
            
            it('should return a specifiy rule', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
        });

        describe('PATCH', function () {

            it('should allow to modify a specific rule', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
            
            it('should refuse a malformed payload', function (done) {
                this.skip();
            });
        });
    });
});