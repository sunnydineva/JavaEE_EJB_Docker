#FROM maven:3.9.2-eclipse-temurin-17
#
#WORKDIR /app-sd
#
##COPY . /app-sd
#
#EXPOSE 18080

#RUN mvn clean install -f app-sd/pom.xml

FROM jboss/wildfly:latest

RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/com/mysql/driver/main

COPY assets/wildfly/module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/driver/main

COPY assets/wildfly/mysql-connector-j-8.2.0.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/driver/main

COPY assets/wildfly/standalone-full.xml /opt/jboss/wildfly/standalone/configuration/

COPY target/ejb.war /opt/jboss/wildfly/standalone/deployments/

RUN /opt/jboss/wildfly/bin/add-user.sh -m -u admin -p admin

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-Djboss.bind.address.management=0.0.0.0","-Djboss.server.default.config=standalone-full.xml", "-b", "0.0.0.0"]

