#!/bin/bash

echo "Deploying vivekapp..."

rm -rf /opt/tomcat/webapps/ROOT*
cp /tmp/vivekapp.war /opt/tomcat/webapps/ROOT.war

echo "Restarting Tomcat..."
/opt/tomcat/bin/shutdown.sh
sleep 3
/opt/tomcat/bin/startup.sh
