# Codename One Spring Template

This repository serves as a template for a Client-Server mobile application that uses Codename One for the client and Spring for the server.

## Features

* Spring REST MVC Web Service back end.
* Codename One Front End - Deployable to iOS, Android, Javascript, Windows Phone, Windows UWP, J2ME, BlackBerry, and Desktop.
* Shared subproject shared by both client and server projects.
* Pass POJOs back and forth from server to client seamlessly via webservice.
* Integrated Push via simple config file. (Requires Codename One Pro account)
* Automated builds for both Local (development) and Production environments.
* Integrated Social Media integration (requires some configuration).  E.g. Facebook and Google Login.

## Setup

1. Check out from GitHub

         $ git clone https://github.com/shannah/codenameone-spring-template.git
         $ cd codenameone-spring-template
2. Copy the `config.properties.sample` file to `config.properties`, then edit it with your application details:
 
 At the start the file will look like:

        base.package.name=com.example
        artifact.prefix=com-example-app
        base.package.path=com/example

 Suppose you want your app's package namespace to be under `com.yourdomain` instead of `com.example`.  Then you would change it to:
        
        base.package.name=com.yourdomain
        artifact.prefix=com-yourdomain-app
        base.package.path=com/yourdomain
3. Now run the `setup` task.
        
        $ ant setup
        
 This will change all of the default files in the template to use your custom base names.
4. Install the shared dependencies into the client and server projects.

        $ ant install-shared

## Project Layout

This application consists of 3 projects:

* client - A NetBeans Codename One project with the client app.
* server - A maven Spring project used for the server.
* shared - A Netbeans project where you can store "shared" classes that can be used in both the client and server project.

## Common Tasks

### Working in the Local Development Environment

This project supports buidling and testing in both "local" and "production" environments.  When building for the "local" environment, you will be running the `server` project on a local java web server (like the GlassFish that is bundled with Netbeans), and the client app will communicate with that local server.  When building for the "production" environment, you would be deploying your server project as a .war and hosting on a publicly available server (usually) e.g. on AWS or a production Tomcat or Glassfish installation, and the client apps would be configured to communicate with this server.

#### Starting the Server

* Open the "server" project in Netbeans.
* Press "Run" in the IDE.  You may need to configure Netbeans to set up your development server, but it will walk you through this.  I generally use the GlassFish 4.1 that is bundled with Netbeans.

#### Running the Client in the Simulator

* Open the "client" project in Netbeans.
* Press "Run".  This will open the client in the Codename One simulator.  It should be configured to connect to your local server.

#### Building the Android App

In terminal in the root directory of the `codenameone-spring-template` project:

~~~~
$ ant build-local-android
~~~~

This android app will be configured to connect to your local server.

#### Building the iOS App

~~~~
$ant build-local-ios
~~~~

This iOS app will be configured to connect to your local server.





