#!/bin/sh

gradle build -x test
gradle buildTestDatabase
gradle deploy
