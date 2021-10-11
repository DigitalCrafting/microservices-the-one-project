#!/bin/bash

set -e

cmd=$@

serviceUp=false

for (( i=0; i<10; i++ ))
do
  if $(curl --output /dev/null --silent --head --fail http://the-one-discovery:8081/health)
  then
    serviceUp=true
    break
  else
    echo "Service not up - try $i"
  fi
  sleep 2
done

if [ $serviceUp == true ]
then
  echo "Service is up - starting command"
  exec $@
else
  echo "Service is unavailable"
fi