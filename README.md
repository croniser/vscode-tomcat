# Maven template for building Tomcat server on VSCode
Runs a tomcat server within VSCode.  Maven build handles dependencies, compilation and deployment.
* Test on Ubuntu 22 with Java 17
## Install Java 11
* Add JVM to $PATH
* Add $JAVA_HOME environment variable
## Install Maven
* Add maven bin to $PATH
## Install Community Server Connector Extension for VS Code  v0.25.7
* newer versions caused issues as of 02/24
## Install Tomcat
* Right click Community Server Connector
    1. Create Server
    2. Download Server
    3. Download Apache Tomcat
    4. Agree to license
## Configure Tomcat
* Right click apache-tomcat
    1. Edit server
    2. Note server.home.dir path
    3. Edit server.home.dir + /conf/tomcat-users.xml
        - before `</tomcat-users>` add:
```        
<role rolename="manager-gui"/>
<role rolename="manager-script"/>
<role rolename="manager-jmx"/>
<role rolename="manager-status"/>
<user username="admin" password="admin" roles="manager-gui,manager-script,manager-jmx,manager-status"/>
```
* Edit server.home.dir + /webapps/manager/META-INF/content.xml
    1. update `<Context>` node to be:
```
<Context antiResourceLocking="false" privileged="true" >
    <Valve className="org.apache.catalina.valves.RemoteAddrValve" allow=".*" />
</Context>
```
## Build project
* Terminal > Run Task > MVN: install - no test
* Confirm .war file created at target/vscode-tomcat-1.0-SNAPSHOT.war
## Deploy project
* Right click .war file
* Run on server
* Select tomcat
* No extra options
## Review project
* Navigation to http://localhost:8080
* Click Manager App button on the right
* Credentials: admin:admin
## Run full build
* Terminal > Run Build Task
