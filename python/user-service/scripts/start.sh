#!/bin/bash

cd $(dirname $0) && cd ..

set -e

source ../venv/bin/activate

if [ "$1" == "dev-docker" ]
then
  docker container run -p 8083:5000 --rm "$2"
elif [ "$1" == "dev-local" ]
then
  ./scripts/wait-for-service.sh  python3 ./src/app.py
fi

deacivate