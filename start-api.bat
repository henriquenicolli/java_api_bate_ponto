@echo off

REM Iniciar os containers Docker
echo Iniciando containers Docker...
cd localstack
docker-compose up -d
cd..

REM iniciar api
echo iniciando api...

cd rep-application\target\
java -jar rep-application-0.0.1-SNAPSHOT.jar

pause
