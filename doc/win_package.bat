@echo off&setlocal EnableDelayedExpansion

rem ������ɫ
color a

rem �������
set /p s=��������������:

%~d0
cd %~dp0\_win

rem �����ļ� ��װ ���� ֹͣ ж�ط���

echo �����ļ��������ɣ����Ե�...
echo.

echo=>��װ����.bat
echo %s%.exe install >��װ����.bat
echo=>��������.bat
echo %s%.exe start >��������.bat
echo=>ֹͣ����.bat
echo %s%.exe stop >ֹͣ����.bat
echo=>ж�ط���.bat
echo %s%.exe uninstall >ж�ط���.bat

timeout /t 1

rem �������exe��xml�����ļ� �ڴ���xml������
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
 
echo �����ļ�������...
echo.

pause