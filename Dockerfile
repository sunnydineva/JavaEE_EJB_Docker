FROM maven:3.9.2-eclipse-temurin-17

WORKDIR /app-sd

COPY . /app-sd

EXPOSE 18080

RUN mvn clean install -f app-sd/pom.xml

FROM jboss/wildfly:latest

COPY target/ejb.war /opt/jboss/wildfly/standalone/deployments/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
