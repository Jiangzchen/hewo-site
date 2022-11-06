@echo off&setlocal EnableDelayedExpansion

rem 设置颜色
color a

rem 传入参数
set /p s=请输入服务的名称:

%~d0
cd %~dp0\_win

rem 创建文件 安装 启动 停止 卸载服务

echo 服务文件正在生成，请稍等...
echo.

echo=>安装服务.bat
echo %s%.exe install >安装服务.bat
echo=>启动服务.bat
echo %s%.exe start >启动服务.bat
echo=>停止服务.bat
echo %s%.exe stop >停止服务.bat
echo=>卸载服务.bat
echo %s%.exe uninstall >卸载服务.bat

timeout /t 1

rem 处理服务exe和xml服务文件 在处理xml的内容
ren *.exe %s%.exe
ren *.xml %s%.xml

set index=0
for /f "eol=* tokens=*" %%i in (%s%.xml) do (
	
	set /a index+=1
	set "var=%%i"
	
	if !index!==3 set "var=<id>%s%</id>"
	if !index!==4 set "var=<name>%s%</name>"
	if !index!==5 set "var=<description>%s%</description>"
	if !index!==7 set "var=<arguments> -jar -server -Xms512m -Xmx1024m -Dfile.encoding=UTF-8 %s%.jar</arguments>"
	echo !var!>>"%s%.xml._"  
	rem echo %%i
)
move "%s%.xml._" "%s%.xml"
 
echo 服务文件已生成...
echo.

pause