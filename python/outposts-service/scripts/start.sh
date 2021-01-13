#!/bin/bash

cd $(dirname $0) && cd ..

set -e

if [ "$1" == "dev-docker" ]
then
  docker container run -p 8084:5000 --rm "$2"
elif [ "$1" == "dev-local" ]
then
  python3 ./src/app.py
fi