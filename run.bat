@echo off
if not exist out mkdir out
javac -d out src\employee_payroll\*.java
if errorlevel 1 pause & exit /b 1
java -cp out employee_payroll.Main
pause
