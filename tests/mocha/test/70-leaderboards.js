// Testing leaderboards/
// ---------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('leaderboards/', function () {

    describe('GET', function () {
        
        it.skip('should return an array of top users', function (done) {
            chai.request(CONFIG.API)
                .get('leaderboards/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug(res);
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.have.lenght(2);
                    // TODO
                    done();
                })
                .catch(function(err) {
                    Utils.debug(err);
                    done(err);
                });
        });

        it('should work with the pagination (per_page)', function (done) {
            this.skip();
        });

        it('should work with the pagination (page)', function (done) {
            this.skip();
        });

        it('should work with the pagination (per_page & page)', function (done) {
            this.skip();
        });

        it('should refuse a bad pagination (negative per_page)', function (done) {
            this.skip();
        });

        it('should refuse a bad pagination (NaN per_page)', function (done) {
            this.skip();
        });

        it('should refuse a bad pagination (negative page)', function (done) {
            this.skip();
        });

        it('should refuse a bad pagination (NaN page)', function (done) {
            this.skip();
        });

        it('should return an empty array with a "over-"pagination', function (done) {
            this.skip();
        });
    });
});