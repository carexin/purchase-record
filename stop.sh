#!/usr/bin/env bash

CURRENT=$(cd $(dirname $0);pwd)

pkill -f $CURRENT/build/libs/pur*.jar

try=5
while [ $try -ge 0 ];do
    let try=$try-1
    pid=$(pgrep -f $CURRENT/build/libs/pur*.jar)
    if [ "$pid" = "" ];then
      break
    else
      echo "Waiting process[$pid] to exit gracefully..."
      sleep 1
    fi
done

if [ "$pid" != "" ];then
   echo "Kill $pid brutally"
    kill -9 $pid
fi