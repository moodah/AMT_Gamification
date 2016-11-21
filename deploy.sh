#!/usr/bin/env sh

set -e

# Build project
./gradlew build

# Deploy and run infrastructure
cp ./build/libs/*.war ./docker/wildfly/standalone/deployments/
docker-compose up --build