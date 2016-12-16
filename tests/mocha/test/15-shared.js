// Shared check
// ------------

// Utils
let chai = require('chai');
let shared = require('./shared');

describe('SHARED', function () {
            
    it('should have a valid token to continue tests', function (done) {
        chai.assert.notEqual(shared.token, null);
        done();
    });
});