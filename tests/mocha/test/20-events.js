// Testing events/
// ---------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');

describe('events/', function () {

    describe('POST', function () {
    
        it('should allow to submit a new event', function (done) {
            this.skip();
        });

        it('should allow to submit many events', function (done) {
            this.skip();
        });
    });
});