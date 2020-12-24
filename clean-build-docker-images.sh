#!/bin/bash

whichProjects=$1

if [ $whichProjects == '' ]
then
  whichProjects='all'
fi

if [ $whichProjects == 'all' ] || [ $whichProjects == 'java' ]
then
  docker image rm digitalcrafting/the-one-discovery digitalcrafting/the-one-gateway

  mvn clean install -f ./java/api-gateway/pom.xml
  mvn clean install -f ./java/service-discovery/pom.xml

  docker build -t digitalcrafting/the-one-discovery ./java/service-discovery/
  docker build -t digitalcrafting/the-one-gateway ./java/api-gateway/
fi

if [ $whichProjects == 'all' ] || [ $whichProjects == 'haskell' ]
then
  docker image rm digitalcrafting/the-one-auth-service

  cabal install --dependencies-only ./haskell/auth-service/auth-service.cabal

  docker build -t digitalcrafting/the-one-auth-service ./haskell/auth-service
fi

if [ $whichProjects == 'all' ] || [ $whichProjects == 'python' ]
then
  docker image rm digitalcrafting/the-one-user-service
  docker image rm digitalcrafting/the-one-outposts-service

  docker build -t digitalcrafting/the-one-user-service ./python/user-service
  docker build -t digitalcrafting/the-one-user-service ./python/outposts-service
fi

if [ $whichProjects == 'all' ] || [ $whichProjects == 'golang' ]
then
  docker image rm digitalcrafting/the-one-logging-service

  go build -o ./golang/logging-service/dist/application.sh ./golang/logging-service/src

  docker build -t digitalcrafting/the-one-logging-service ./golang/logging-service
fi
