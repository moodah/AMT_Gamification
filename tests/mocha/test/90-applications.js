// Testing applications/
// ---------------------

// Utils
let chai = require('chai');
let chaiHttp = require('chai-http');
chai.use(chaiHttp);
let CONFIG = require('./config');

describe('applications/', function () {

    describe('DELETE', function () {
            
        it('should allow to delete an application', function (done) {
            chai.request(CONFIG.API)
                .delete('application/')
                .set('content-type', 'application/json')
                .set('authorisation', CONFIG.token)
                .send({
                    name: 'testapplicationname'
                })
                .then(function (res) {
                    chai.expect(res).to.not.be.undefined;
                    chai.expect(res).to.have.status(200);
                    done();
                })
                .catch(function (err) {
                    done(err);
                });
        });
    });
});