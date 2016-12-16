// Config check
// ------------

// Utils
let chai = require('chai');
let CONFIG = require('./config');

describe('CONFIG', function () {
            
    it('should have a valid token to continue tests', function (done) {
        chai.assert.notEqual(CONFIG.token, null);
        done();
    });
});