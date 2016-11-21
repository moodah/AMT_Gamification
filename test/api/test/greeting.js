var request = require("supertest-as-promised");
var chai = require('chai');

describe('The /greeting endpoint', function(done) {

    it('should return "Hello, World!" if no name is provided', function(done) {
        request("http://192.168.99.100:9090/amt-gamification-0.1.0")
            .get("/greeting")
            .expect(200)
            .expect(function(res) {
                chai.expect(res.body.content).to.include('World');
            })
            .end(done);
    });

    it('should return "Hello, Jack!" if the name "Jack" is provided', function(done) {
        request("http://192.168.99.100:9090/amt-gamification-0.1.0")
            .get("/greeting?name=Jack")
            .expect(200)
            .expect(function(res) {
                chai.expect(res.body.content).to.include('Jack');
            })
            .end(done);
    });

});