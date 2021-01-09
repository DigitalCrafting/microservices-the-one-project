#!/bin/bash

# Make sure the root directory is the scripts directory
cd $(dirname $0)

if [ "$1" == "user" ]
then
  if [ "$2" == "dev-local" ]
  then
    user-service/build.sh "dev-local"
  elif [ "$2" == "dev-docker" ]
  then
    user-service/build.sh "dev-docker"
  fi
elif [ "$1" == "outpost" ]
then
  if [ "$2" == "dev-local" ]
  then
    outposts-service/build.sh "dev-local"
  elif [ "$2" == "dev-docker" ]
  then
    outposts-service/build.sh "dev-docker"
  fi
elif [ "$1" == "dev-local" ]
then
  user-service/build.sh "dev-local"
  outposts-service/build.sh "dev-local"
elif [ "$1" == "dev-docker" ]
then
  user-service/build.sh "dev-docker"
  outposts-service/build.sh "dev-docker"
else
  echo "Incorrect arguments, usage:"
  echo "<script> [user|outpost|<none>] dev-[local|docker]"
  echo ""
fi
