#!/usr/bin/env bash

CLASSPATH="$CLASSPATH:../lib/*;../config/*"

export CLASSPATH

nohup java -jar hyc-fas-0.0.1.jar -Dflag=hyc-fas &
