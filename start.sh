#!/usr/bin/env bash

CURRENT=$(cd $(dirname $0);pwd)

nohup java $JAVA_OPTS -Dserver.port=9005 -Dlogs.dir=$2 -jar $CURRENT/build/libs/pur*.jar &>/dev/null &