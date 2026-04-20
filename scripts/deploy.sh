#!/bin/bash

echo "Deploying vivekapp on RHEL..."

# Stop Tomcat (RHEL service-based)
echo "Stopping Tomcat..."
sudo systemctl stop tomcat

# Clean old app
#echo "Cleaning old deployment..."
#sudo rm -rf /var/lib/tomcat/webapps/ROOT*
#sudo rm -rf /var/lib/tomcat/webapps/vivekapp*

# Copy new WAR
#echo "Copying new WAR..."
sudo cp /tmp/target/vivekapp.war /var/lib/tomcat/webapps/

# Set ownership (important for RHEL)
sudo chown tomcat:tomcat /var/lib/tomcat/webapps/*

# Start Tomcat
echo "Starting Tomcat..."
sudo systemctl start tomcat

echo "Deployment complete!"
