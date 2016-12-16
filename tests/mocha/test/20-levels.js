// Testing levels/
// ---------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');

describe('levels/', function () {

    describe('POST', function () {
        
        it('should allow to create a new level', function (done) {
            this.skip();
        });

        it('should allow to create many levels', function (done) {
            this.skip();
        });

        it('should refuse a malformed payload', function (done) {
            this.skip();
        });
    });

    describe('GET', function () {
        
        it('should return an array of created levels', function (done) {
            this.skip();
        });
    });

    describe('levels/{id}', function () {
        
        describe('GET', function () {
            
            it('should return a specifiy level', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
        });

        describe('PATCH', function () {

            it('should allow to modify a specific level', function (done) {
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