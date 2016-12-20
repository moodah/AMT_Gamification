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

    describe('POST', function () {
    
        it('should allow to submit a new event', function (done) {
            this.skip();
        });

        it('should allow to submit many events', function (done) {
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