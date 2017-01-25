// Setup
// -----

let CONFIG = require('./config');
let shared = require('./shared');
let Utils = require('./utils');

before(function () {
    console.log('Starting tests suites...');
    console.log('API is at: ' + CONFIG.API);
    console.log(''); // pretty
    Utils.debug('shared', shared);
});

after(function () {
    console.log('End of tests suites.')
    Utils.debug('shared', shared);
});