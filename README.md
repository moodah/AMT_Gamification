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
- You can also run the Spring Boot application with `./gradlew bootRun` from the `platform` folder
- The server will listen on the port `8080`
- Livereload is made on project build in intelliJ IDEA (Build -> Build Project)

*If you want intelliJ to build your project automatically : File -> Settings... -> Build, Execution, Deployment -> Compiler (click on it) -> Enable checkbox "Build project automatically". 
At this stage, you won't need to save or build your project anymore, build will be automatically done on file changes. This action will trigger the livereload. It's up to you to decide if you want to activate this feature or not*

## Tests
All the testing are in the `tests/` folder: [here](https://github.com/moodah/AMT_Gamification/tree/master/tests)

## Generate server with Swagger
- In swagger online editor, select Generate Server > Spring
- Unzip the downloaded folder
- At project root, run `gradle init` to create all gradle files
- Open the `build.gradle` file generated and copy paste missing dependencies in your `build.gradle` project file
- IMPORTANT : Update versions of dependencies with the latest
- Copy paste the `src` folder in your project
```
[...]

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-web', version:'1.4.2.RELEASE'
    compile group: 'org.springframework.boot', name: 'spring-boot-devtools', version:'1.4.2.RELEASE'
    compile group: 'io.springfox', name: 'springfox-swagger2', version:'2.6.1'
    compile group: 'io.springfox', name: 'springfox-swagger-ui', version:'2.6.1'
    compile group: 'com.fasterxml.jackson.datatype', name: 'jackson-datatype-joda', version:'2.8.5'
    compile group: 'joda-time', name: 'joda-time', version:'2.9.6'

    testCompile('org.springframework.boot:spring-boot-starter-test')
}
```

- Run `./gradlew bootRun`

App is available at `localhost:8080/v1` (settings can be change in `src/main/resources/application.properties`)
