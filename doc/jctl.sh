#!/bin/bash

# 判断是否有参数指定脚本行为
ERR_HELP="错误：缺少参数，启动方式： jctl.sh service-name start/stop/restart"

### 获取APP名称
if [ "$2" == "" ]; then
    echo $ERR_HELP
    exit 0
    else
    APP_NAME=$1
fi
### 服务目录
APP_HOME=/mnt/hewo/$APP_NAME
mkdir -p $APP_HOME/logs

var=$(date +%Y%m%d%H%M)

startUp()
{
    pid=`ps -ef | grep $APP_NAME | grep -v jctl.sh | grep -v grep | awk '{print $2}'`
    if [[ ! -z "$pid" ]]
        then 
        echo 服务已经在运行中，不允许此操作！
        echo 当前pid: $pid
        exit 0
    fi

    echo 正在启动服务，请稍等...
    echo

    nohup java -jar $APP_HOME/$APP_NAME.jar >> $APP_HOME/logs/run.log 2>&1 &

    sleep 3

    echo 服务启动成功...
    echo

}

stopNow()
{
    echo 正在停止服务...
    echo
    pid=`ps -ef | grep $APP_NAME | grep -v jctl.sh | grep -v grep | awk '{print $2}'`
    kill -9 $pid
    echo
    echo 服务已停止！
    echo
}

bakDir()
{
	find $APP_HOME -name '*.*.bak*' | xargs rm -rvf
	
	echo 正在备份服务，请稍等...
	echo
	
	#重命名备份jar包
	mv $APP_HOME/$APP_NAME.jar $APP_HOME/$APP_NAME.jar.bak$var
	
	sleep 3
	
	echo 备份服务成功...
	echo
}

case "$2" in
    'start')
        startUp;
        echo;
        ;;
	'bak')
        bakDir;
        echo;
        ;;
    'stop')
        stopNow;
        echo;
        ;;
    'restart')
        stopNow;
        startUp;
        ;;
    *)
        echo $ERR_HELP
        ;;
esac
exit 0
