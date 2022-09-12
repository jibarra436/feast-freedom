FROM tomcat:8-jre8-openjdk
ADD target/FeastFreedom.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]