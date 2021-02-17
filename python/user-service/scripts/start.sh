#!/bin/bash

cd $(dirname $0) && cd ..

set -e

if [ "$1" == "dev-local" ]
then
  source ../venv/bin/activate
  ./scripts/wait-for-service.sh  python3 ./src/app.py
  deacivate
else
  echo "start.sh: Incorrect argument"
fi