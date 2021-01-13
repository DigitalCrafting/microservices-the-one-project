#!/bin/bash

cd $(dirname $0) && cd ..

if [ "$1" == "dev-docker" ]
then
  docker container run -p 8081:8080 --rm "$2"
elif [ "$1" == "dev-local" ]
then
  mvn spring-boot:run -P"$1"
fi

