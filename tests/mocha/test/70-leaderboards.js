// Testing leaderboards/
// ---------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');

describe('leaderboards/', function () {

    describe('GET', function () {
        
        it('should return an array of top users', function (done) {
            chai.request(CONFIG.API)
                .get('leaderboards/')
                .set('autorization', shared.token)
                .then(function(res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('body');
                    chai.expect(res.body).to.have.lenght(2);
                    this.skip(); // TODO
                    done();
                })
                .catch(function(err) {
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