# Testing 

To run the tests:
- Start the platform, see [here](https://github.com/moodah/AMT_Gamification#how-to) 
- Open your favorite terminal
- Move to this directory (`AMT_Gamification/tests/`)
- Optionally, if you changed the platform configuration, modify this file:
    - `AMT_Gamification/tests/mocha/test/config.js`
- Execute `docker-compose up`

## Structure

They are many testing approachs in this folder, here we come with some explanations.

### JMeter

This part tests the high load and concurrency of the platform. It is only composed of a JMeter script, which ...

### MochaJS

This part tests the platform REST API behaviors and correctness. It is composed of many Javascript files in the `test/` sub-folder. The files are numbered to follow a logic order, which is important because some tests suites depend on previous ones.

## Resources

- http://mochajs.org/
- http://chaijs.com/
- http://chaijs.com/plugins/chai-http/
- https://jmeter.apache.org/
