/*


JAR -> java archive
    -> self contained java application
    -> they will run there app by themself
    -> they will run the main method of the app and then the app will run
    -> we run the command java -jar app.jar to run the app
    -> something like this -> node app.js
    -> spring boot creates jar file of the app and then we can run that jar file to run the app
    -> spring boot creates executable jar file of the app and then we can run that jar file

WAR -> web archive
    -> a package meant to be deployed on a web server
    -> they will not run there app by themself
    -> they will deploy the app on a web server and then the web server will run the app
    -> WAR → deployed to Tomcat/Jetty → server runs it


FLOW
 with war
   Browser → /todos
        ↓
Server (Jetty/Tomcat)
        ↓
DispatcherServlet (Spring)
        ↓
Controller → Service → Repository


-> jar execution flow 


    java -jar app.jar
      ↓
JVM starts main()
      ↓
Your code runs
      ↓
(Optional) starts server (like Spring Boot)

-> war execution flow

    Server (Tomcat/Jetty) starts
        ↓
Loads WAR file
        ↓
Reads web.xml / config
        ↓
Initializes DispatcherServlet
        ↓
Handles requests


WAR components

app.war
 ├── WEB-INF/
 │    ├── web.xml              ← entry config
 │    ├── classes/             ← compiled classes
 │    └── lib/                 ← dependencies
 ├── static files (html/css/js)


 web.xml -> Defines how server should start your app
 DispatcherServlet -> Spring's front controller that routes requests to controllers ( app from express )


 JAR components

 app.jar
 ├── META-INF/
 │    └── MANIFEST.MF   (contains main class)
 ├── com/navneet/...    (your compiled classes)
 └── dependencies (optional)

 MANIFEST.MF → tells JVM which main() to run














 */