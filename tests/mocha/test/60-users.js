// Testing users/
// --------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

describe('users/', function () {

    describe('GET', function () {
        
        it('should return an array of users', function (done) {
            chai.request(CONFIG.API)
                .get('users/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    Utils.debug('res', res);
                    chai.expect(res).to.not.be.null;
                    chai.expect(res).to.have.status(200);
                    chai.expect(res).to.have.property('text');
                    chai.expect(JSON.parse(res.text)).to.have.lengthOf(2);
                    chai.expect(JSON.parse(res.text)[0].user_id).to.equal(0);
                    chai.expect(JSON.parse(res.text)[0].points).to.equal(5);
                    chai.expect(JSON.parse(res.text)[0].level.name).to.equal('none');
                    chai.expect(JSON.parse(res.text)[0].badges).to.have.lengthOf(1);
                    chai.expect(JSON.parse(res.text)[0].badges[0].name).to.equal('super-writer');
                    chai.expect(JSON.parse(res.text)[1].user_id).to.equal(1);
                    chai.expect(JSON.parse(res.text)[1].points).to.equal(20);
                    chai.expect(JSON.parse(res.text)[1].level.name).to.equal('semi-pro');
                    chai.expect(JSON.parse(res.text)[1].badges).to.have.lengthOf(0);
                    done();
                })
                .catch(function(err) {
                    Utils.debug('err', err);
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
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .then(function (res) {
                        Utils.debug('res', res);
                        chai.expect(res).to.not.be.null;
                        chai.expect(res).to.have.status(200);
                        chai.expect(res).to.have.property('text');
                        chai.expect(JSON.parse(res.text).user_id).to.equal(0);
                        chai.expect(JSON.parse(res.text).points).to.equal(5);
                        chai.expect(JSON.parse(res.text).level.name).to.equal('none');
                        chai.expect(JSON.parse(res.text).badges).to.have.lengthOf(1);
                        chai.expect(JSON.parse(res.text).badges[0].name).to.equal('super-writer');
                        done();
                    })
                    .catch(function(err) {
                        Utils.debug('err', err);
                        done(err);
                    });
            });

            it('should not allow an undefined ID', function (done) {
                chai.request(CONFIG.API)
                    .get('users/8239/')
                    .set('content-type', 'application/json')
                    .set('authorization', shared.token)
                    .end(function(err, res) { 
                        Utils.debug('err', err);
                        chai.expect(err).to.not.be.null;
                        chai.expect(err).to.have.status(404);
                        done();
                    });
            });
        });
    });
});