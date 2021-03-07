#!/bin/bash

cd $(dirname $0) && cd ..

if [ "$1" == "dev-local" ]
then
  mvn spring-boot:run -P"$1",build-angular
else
  echo "start.sh: Incorrect argument"
fi

