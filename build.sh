#!/bin/sh

gradle build -x test
gradle deploy
