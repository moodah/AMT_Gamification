FROM java:8

VOLUME /tmp

ADD ./build.gradle /app/build.gradle
ADD ./gradle/ /app/gradle/
ADD ./gradlew /app/gradlew

ADD ./src/ /app/src/

RUN /app/gradlew build

RUN bash -c 'touch /app/build/libs/amt-gamification-0.0.1.jar'

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/build/libs/amt-gamification-0.0.1.jar"]
