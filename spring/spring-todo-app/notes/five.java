/*

-> In this step we will make it real -> means it will handle real http request and our controller
   will send http response to the client

-> we will use spring mvc for this and we will see how to configure it in our application
-> first we need to add this dependency in our pom.xml file like this

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.30</version>
</dependency>

this dependecy will give us ->
        -> Controller annotations (@Controller)
        -> Request mapping (@GetMapping)
        -> DispatcherServlet

// also to handle request , we need a server , spring does not start server automatically
// so need apache tomcat server for that
// for tomcar also we need to add dependency in pom.xml file like this


<build>
    <plugins>
        <plugin>
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
            <configuration>
                <port>8080</port>
                <path>/</path>
            </configuration>
        </plugin>
    </plugins>
</build>

// as you can see in the above code we are telling maven to start tomcat server 
// on port 8080 and with context path /

// apart from this we need to tell apache tomcat to use spring dispatcher servlet to handle the request
// for that we need to add this code in web.xml file

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         version="3.1">

    <servlet>
        <servlet-name>spring-dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring-servlet.xml</param-value>
        </init-param>

        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>spring-dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>

</web-app>


// in controller section we will use 

@Controller → marks it as web controller
@GetMapping("/todos") → route
@ResponseBody → return HTTP response




 */

/*
// errors and other things to note

-> some error occured and then we added <packaging>war</packaging> in pom.xml file and then it worked fine
-> also we are using jetty server and not tomcat server 
-> changing anything in the config , we need to run mvn clean
-> then now we are not running these two commands 

mvn compile
mvn exec:java -Dexec.mainClass="com.navneet.todo.App"

now we are running -> mvn jetty:run





 */