// Testing DELETE verb
// -------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');

describe('rules/', function () {

    describe('DELETE', function () {
        
        it('should allow to delete all rules', function (done) {
            this.skip();
        });
    });

    describe('rules/{id}', function () {

        describe('DELETE', function () {
            
            it('should allow to delete a specific rule', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
        });
    });
});

describe('badges/', function () {

    describe('DELETE', function () {
                
        it('should allow to delete all badges', function (done) {
            this.skip();
        });
    });

    describe('badges/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific badge', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
        });
    });
});

describe('levels/', function () {

    describe('DELETE', function () {
                
        it('should allow to delete all levels', function (done) {
            this.skip();
        });
    });

    describe('levels/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific level', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
        });
    });
});

describe('applications/', function () {

    describe('DELETE', function () {
            
        it('should allow to delete an application', function (done) {
            chai.request(CONFIG.API)
                .delete('application/')
                .set('content-type', 'application/json')
                .set('authorization', shared.token)
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(204);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });
    });
});