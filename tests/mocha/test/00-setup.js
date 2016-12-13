// Setup
// -----

let CONFIG = require('./config');

before(function () {
    console.log('Starting tests suites...');
    console.log('API is at: ' + CONFIG.API);
    console.log(''); // pretty
});

after(function () {
    console.log('End of tests suites.')
});