// Testing DELETE verb
// -------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');
let shared = require('./shared');

describe('achievements/', function () {

    describe('DELETE', function () {
                
        it('should allow to delete all achievements', function (done) {
            this.skip();
        });
    });

    describe('achievements/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific achievement', function (done) {
                this.skip();
            });

            it('should not allow an undefined ID', function (done) {
                this.skip();
            });
        });
    });
});

describe('eventtypes/', function () {

    describe('DELETE', function () {
                
        it('should allow to delete all eventtypes', function (done) {
            this.skip();
        });
    });

    describe('eventtypes/{id}', function () {

        describe('DELETE', function () {
                        
            it('should allow to delete a specific eventtype', function (done) {
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
                .delete('applications/')
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