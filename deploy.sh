#!/usr/bin/env sh

set -e

# Build project
./gradlew build

# Deploy and run infrastructure
cp ./build/libs/amt-gamification-0.0.1.jar ./docker/java/
docker-compose up --build