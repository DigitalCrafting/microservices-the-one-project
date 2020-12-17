#!/bin/bash

docker image rm digitalcrafting/the-one-discovery digitalcrafting/the-one-gateway

mvn clean install -f ./java/api-gateway/pom.xml
mvn clean install -f ./java/service-discovery/pom.xml

docker build -t digitalcrafting/the-one-discovery ./java/service-discovery/
docker build -t digitalcrafting/the-one-gateway ./java/api-gateway/