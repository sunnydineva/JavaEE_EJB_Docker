#FROM maven:3.9.2-eclipse-temurin-17
#
#WORKDIR /app-sd
#
##COPY . /app-sd
#
#EXPOSE 18080

#RUN mvn clean install -f app-sd/pom.xml

FROM jboss/wildfly:25.0.0.Final

RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/com/mysql/driver/main

COPY assets/wildfly/module.xml /opt/jboss/wildfly/modules/system/layers/base/com/mysql/driver/main

COPY assets/wildfly/mysql-connector-j-8.2.0.jar /opt/jboss/wildfly/modules/system/layers/base/com/mysql/driver/main

COPY assets/wildfly/standalone-full.xml /opt/jboss/wildfly/standalone/configuration/

# COPY assets/wildfly/standalone.conf /opt/jboss/wildfly/bin/

#see volume on docker-compose:
#===========================
RUN rm -rf deployment

COPY target/ejb.war /opt/jboss/wildfly/standalone/deployments/
#===========================

 # address=*:portSeems like in java8 address could just be port and by java11 address means address and port for systems with multiple interface, I presume.
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8787"

RUN /opt/jboss/wildfly/bin/add-user.sh -m -u admin -p admin

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-Djboss.bind.address.management=0.0.0.0","-Djboss.server.default.config=standalone-full.xml", "-b", "0.0.0.0"]


