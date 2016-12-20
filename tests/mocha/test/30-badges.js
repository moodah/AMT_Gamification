// Testing badges/
// ---------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('badges/', function () {

    describe('POST', function () {
        
        it('should allow to create a new badge', function (done) {
            this.skip();
        });

        it('should allow to create many badges', function (done) {
            this.skip();
        });

        // malformed payloads
        Utils.generateMalformed({
            notDefinedAtTheMoment: ''
        }).forEach(function(malformed) {

            it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                this.skip();
            });
        });
    });

    describe('GET', function () {
        
        it('should return an array of created badges', function (done) {
            this.skip();
        });
    });

    describe('badges/{id}', function () {
        
        describe('GET', function () {
            
            it('should return a specifiy badge', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
        });

        describe('PATCH', function () {

            it('should allow to modify a specific badge', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
            
            // malformed payloads
            Utils.generateMalformed({
                notDefinedAtTheMoment: ''
            }).forEach(function(malformed) {

                it('should refuse a malformed payload (' + malformed.what + ')', function (done) {
                    this.skip();
                });
            });
        });
    });
});