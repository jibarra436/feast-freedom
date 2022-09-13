FROM tomcat:8-jre8-openjdk
RUN sed -i 's/port="8080"/port="8081"/' ${CATALINA_HOME}/conf/server.xml
ADD target/FeastFreedom-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]