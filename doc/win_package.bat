@echo off&setlocal EnableDelayedExpansion

rem ������ɫ
color a

rem �������
set /p s=��������������:

%~d0
cd %~dp0\_win11

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

set ctr=0 

for /f "eol=* tokens=*" %%i in (%s%.xml) do (

rem ���ñ���aΪÿ������

echo ctr
   
rem ���޸ĺ��ȫ���д���$
echo !a!>>$)
rem move $ %s%.xml

echo �����ļ�������...
echo.

pause