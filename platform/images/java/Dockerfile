FROM java:8

WORKDIR /platform

ADD ./build.gradle ./gradlew ./
ADD ./gradle ./gradle
ADD ./src ./src

RUN ./gradlew build

RUN bash -c 'touch /platform/build/libs/amt-gamification-0.0.1.jar'

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/platform/build/libs/amt-gamification-0.0.1.jar"]
