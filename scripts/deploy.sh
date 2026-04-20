#!/bin/bash

echo "Deploying vivekapp on RHEL..."

# Stop Tomcat (RHEL service-based)
echo "Stopping Tomcat..."
systemctl stop tomcat

# Clean old app
echo "Cleaning old deployment..."
rm -rf /var/lib/tomcat/webapps/ROOT*
rm -rf /var/lib/tomcat/webapps/vivekapp*

# Copy new WAR
echo "Copying new WAR..."
cp /tmp/vivekapp.war /var/lib/tomcat/webapps/ROOT.war

# Set ownership (important for RHEL)
chown tomcat:tomcat /var/lib/tomcat/webapps/ROOT.war

# Start Tomcat
echo "Starting Tomcat..."
systemctl start tomcat

echo "Deployment complete!"
