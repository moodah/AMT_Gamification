FROM java:8

VOLUME /tmp

ADD ./ /app/

CMD /app/gradlew build

RUN bash -c 'touch /app/build/libs/amt-gamification-0.0.1.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/build/libs/amt-gamification-0.0.1.jar"]
