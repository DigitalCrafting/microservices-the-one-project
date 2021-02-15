#!/bin/bash

cd $(dirname $0) && cd ..

set -e

if [ "$1" == "dev-docker" ]
then
  docker container run -p 8083:8083 --rm "$2"
elif [ "$1" == "dev-local" ]
then
  source ../venv/bin/activate
  ./scripts/wait-for-service.sh  python3 ./src/app.py
  deacivate
fi