FROM tomcat:latest
# Take the war and copy to webapps of tomcat
COPY target/calculator.war /usr/local/tomcat/webapps/calculator.war
