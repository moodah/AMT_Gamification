// Testing users/
// --------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');

describe('users/', function () {

    describe('GET', function () {
        
        it('should return an array of users', function (done) {
            chai.request(CONFIG.API)
                .get('users/')
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

    describe('users/{id}/', function () {
        
        describe('GET', function () {
            
            it('should return a specific user', function (done) {
                chai.request(CONFIG.API)
                    .get('users/0/')
                    .set('autorization', shared.token)
                    .then(function(res) {
                        chai.expect(res).to.not.be.undefined;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('body');
                        this.skip(); // TODO
                        done();
                    })
                    .catch(function(err) {
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('users/8239/')
                    .set('autorization', shared.token)
                    .end(function(err, res) {
                        chai.expect(err).to.not.be.undefined;
                        chai.expect(err).to.have.status(400);
                        done();
                    });
            });
        });
    });
});