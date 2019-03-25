#/bin/bash

branch=pub

CURRENT=$(cd $(dirname $0);pwd)

git_dir=$CURRENT
backups_home=$CURRENT/backups
backups_path=$backups_home/`date +%Y-%m-%d-%H%M`/


echo "git checkout start"
cd $git_dir
now=`date '+%Y-%m-%d %H:%M:%S'`
git checkout $branch
check_new=`git pull`
if [[ $check_new =~ "Already" ]]
then
  minute=`date '+%M'`
  if [ $minute -lt 10 ]
  then
    echo "拉取git仓库源码end"
    echo "$now 没有可更新的版本"
  fi
    echo "拉取git仓库源码end"
else

  echo "拉取git仓库源码end"
  mkdir $backups_path
  echo "备份start,备份路径:"$backups_path
  cp $git_dir/build/libs/purchase-record-0.0.1-SNAPSHOT.jar $backups_path
  echo "备份end"

  cd $git_dir
  echo "gradle 编译打包start"
  ./gradlew bootJar
  echo "mvn编译打包end"

  echo "关闭服务器"
  bash $git_dir/stop.sh
  sleep 5
  echo "正在启动链金付电子拆票系统,当前分支:" $branch"……"
  bash $git_dir/start.sh
  echo "启动命令执行完毕"
 fi