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