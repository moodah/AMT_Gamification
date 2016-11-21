FROM jboss/wildfly:10.1.0.Final

COPY standalone/deployments /opt/jboss/wildfly/standalone/deployments
COPY standalone/configuration/standalone.xml /opt/jboss/wildfly/standalone/configuration/

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]