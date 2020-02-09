#!/usr/bin/env
sh "$(dirname "$0")/build.sh"
mvn package deploy -P release -DskipTests