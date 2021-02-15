FROM openjdk:11-jdk-slim
VOLUME /tmp
COPY target/api-gateway-0.0.1-SNAPSHOT.jar gateway.jar
COPY scripts/wait-for-service.sh script.sh
RUN apt-get update && apt-get install -y curl
CMD ./script.sh java -jar gateway.jar
