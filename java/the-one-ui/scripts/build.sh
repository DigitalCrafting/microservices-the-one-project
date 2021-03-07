#!/bin/bash

cd $(dirname $0) && cd ..

mvn clean install -P"$1",build-angular