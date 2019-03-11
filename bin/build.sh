#!/usr/bin/env bash

mvn clean package -Dmaven.test.skip=true -f ../pom.xml -P release
