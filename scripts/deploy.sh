#!/usr/bin/env
sh "$(dirname "$0")/build.sh"
mvn clean package deploy -P release -DskipTests