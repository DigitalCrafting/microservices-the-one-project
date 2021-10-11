FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/users-service-0.0.1-SNAPSHOT.jar service.jar
COPY scripts/wait-for-service.sh script.sh
RUN apt-get update && apt-get install -y curl
CMD ./script.sh java -jar service.jar
#ENTRYPOINT ["java","-jar","service.jar"]
