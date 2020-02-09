#!/usr/bin/env
mvn clean verify -DskipTests=true deployment:run -Dbuilder -Dtag -Dupdate.major