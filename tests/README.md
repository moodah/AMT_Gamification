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

This part tests the high load and concurrency of the platform. It is only composed of a JMeter script, which initialize a new application and add some event types. Then, it starts to add events with several concurrents threads.

This test showed us that there is no concurrency problem with the most problematic part of the API. Add events will be the most used endpoint of the application. At the end of the test, the user points are correct.

The JMeter script is located under the `jmeter/` sub-folder. To use it, it's necessary to configure the URL to the API inside JMeter.

### MochaJS

This part tests the platform REST API behaviors and correctness. It is composed of many Javascript files in the `test/` sub-folder. The files are numbered to follow a logic order, which is important because some tests suites depend on previous ones.

## Resources

- http://mochajs.org/
- http://chaijs.com/
- http://chaijs.com/plugins/chai-http/
- https://jmeter.apache.org/
