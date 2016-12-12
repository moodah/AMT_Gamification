# AMT_Gamification
# Context
This repo contains the code to run a gamification API. It is a project proposed by [Olivier Liechti](https://github.com/wasadigi) in the context of our [AMT lesson](https://github.com/SoftEng-HEIGVD/Teaching-HEIGVD-AMT-Lectures) at HEIG-VD.

# How to

## Setup
Before getting started you'll need [Docker 1.12+](https://docs.docker.com/) and [Docker Compose 1.8+](https://docs.docker.com/compose/).

## Run the app
Then, after cloning this repo, run the project with the command `docker-compose up --build`. Docker images will start a MySQL database and build/run the server.

- Clone this repo
- Open your terminal and browse at the root of the folder (same level as the `docker-compose.yml` file)
- Run the following command `docker-compose up`
- Open your browser and access the url `http://127.0.0.1:8080/` or `http://192.168.99.100:8080/` depending your installation (docker-machine or docker for Windows/Mac)
- Magic happens !

## Other access
After you've got launched the application with docker-compose, you can access :

- PHPMyAdmin on the port `6060`
- MySQL on the port `3306`

## Run the app for development
- You can also run the Spring Boot application with `./gradlew bootRun`
- The server will listen on the port `8080`

## Tests
All the testing are in the `tests/` folder: [here](https://github.com/moodah/AMT_Gamification/tree/master/tests)

## Generate server with Swagger
- In swagger online editor, select Generate Server > Spring
- Unzip the downloaded folder
- At project root, run `gradle init` to create all gradle files
- Copy paste the `src` folder in your project
- Copy paste gradle files also

Add missing dependencies in gradle
```json
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.2.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'maven'
apply plugin: 'org.springframework.boot'

group = 'io.swagger'
version = '1.0.0'

description = """swagger-spring"""

sourceCompatibility = 1.8
targetCompatibility = 1.8
tasks.withType(JavaCompile) {
	options.encoding = 'UTF-8'
}



repositories {
        
     maven { url "http://repo.maven.apache.org/maven2" }
}
dependencies {
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-web', version:'1.3.5.RELEASE'
    compile group: 'io.springfox', name: 'springfox-swagger2', version:'2.5.0'
    compile group: 'io.springfox', name: 'springfox-swagger-ui', version:'2.5.0'
    compile group: 'com.fasterxml.jackson.datatype', name: 'jackson-datatype-joda', version:'2.6.6'
    compile group: 'joda-time', name: 'joda-time', version:'2.8.2'
    compile(group: 'org.springframework.boot', name: 'spring-boot-starter-tomcat', version:'1.3.5.RELEASE') {
       /* This dependency was originally in the Maven provided scope, but the project was not of type war.
       This behavior is not yet supported by Gradle, so this dependency has been converted to a compile dependency.
       Please review and delete this closure when resolved. */
    }
}
```

App is available at `localhost:8080/v1` (settings can be change in `src/main/resources/application.properties`)
