FROM adoptopenjdk:16-jre-hotspot
RUN mkdir /opt/app
COPY target/question-time-api-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8080/tcp
CMD ["java", "-jar", "/opt/app/question-time-api-0.0.1-SNAPSHOT.jar"]
