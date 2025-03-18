
## Before Start/Build Airline App
1.  Ensures ejb.war in __/target__ folder.
2.  if not => a) or b)
a) `mvn clean install'
b) docker build -t app-sd .

## Start Airline App
1. cd __/target__
2. docker-compose up
3. ensure ejb.war in __/deployment__ folder if not => follow steps of "Deploy Airline App - Optional"

## Deploy Airline App - Optional
1. Ensures app-sd container is running
2. Deploy ejb.war:
2.1. clear the content of __/deployment__ folder
2.2. put ejb.war in  __/deployment__ folder by a) or b)
a) copy __/target/ejb.war to __/deployment/ejb.war
b) docker cp target/ejb.war $(docker ps -qf "name=app-sd"):/opt/jboss/wildfly/standalone/deployments/

## Use Airline App
Go to: http://localhost:28080/ejb/airLineForms
Management of Wildfly:  http://0.0.0.0:29990/management admin admin


## Start only DB ir App
run only mySQL container:
docker run -p 11306:113306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db-sd mysql:8.0.0

create image of javaee:SNAPSHOT-1.0.0 - if we use image, instead of build in services:
       services:
         app-sd:
         image: javaee:SNAPSHOT-1.0.0
  sunny@sunny:~/ss/projects/JavaEE_EnterpriseJavaBeans$ docker build -t javaee:SNAPSHOT-1.0.0 .
  sunny@sunny:~/ss/projects/JavaEE_EnterpriseJavaBeans$ docker build --no-cache -t javaee:SNAPSHOT-1.0.0 .

 run all containers (mySQL & app-sd) defined in docker-compose.yml:
  sunny@sunny:~/ss/projects/JavaEE_EnterpriseJavaBeans$ docker compose up




