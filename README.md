# hewo-site

使用/doc/jctl.sh 管理服务

###### 指令运行格式

> /jctl.sh service-name start | stop | restart | bak

###### 应用示例

``` bash
> /jctl.sh #假定脚本放在根目录 (说明下是在 cd / )

> /mnt/hewo/hewo-site/hewo-site.jar
```

###### 控制命令
```bash
> /jctl.sh hewo-site restart

> /jctl.sh hewo-site-new restart
```

注：下载后解压，并为 jctl.sh 添加执行权限（例：chmod +x /jctl.sh）；运行后服务目录下会记录控制台输出日志。