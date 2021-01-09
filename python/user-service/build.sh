#!/bin/bash

# Make sure the root directory is the scripts directory
cd $(dirname $0)

if [ "$1" == "dev-local" ]
then
  cp ./configs/config-dev-local.py ./src/config/config.py
elif [ "$1" == "dev-docker" ]
then
  cp ./configs/config-dev-docker.py ./src/config/config.py
else echo "Incorrect arguments"
fi