FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/users-service-0.0.1-SNAPSHOT.jar service.jar
ENTRYPOINT ["java","-jar","service.jar"]
