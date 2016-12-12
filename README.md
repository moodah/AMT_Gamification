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
