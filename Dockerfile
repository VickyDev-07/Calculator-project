FROM tomcat:10.1.5
# Take the war and copy to webapps of tomcat
COPY target/calculator.war /usr/local/tomcat/webapps/
