/*

-> in this step we will add postgresql in our app
-> so for that we need to install postgres in our system 

command 1 -> sudo dnf install postgresql-server postgresql-contrib
command 2 -> sudo postgresql-setup --initdb (initializing the database)

// start the service of postgres

command 3 -> sudo systemctl start postgresql
command 4 -> sudo systemctl enable postgresql

// verify that postgres is running
command 5 -> sudo -u postgres psql

// after all these , we need to create the database also

-> CREATE DATABASE todo_app;
-> \c todo_app;

CREATE TABLE todos (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL
);

-> now we need to add jdbc dependency in our pom.xml file to connect our app with postgres database

<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>

then we need to configure datasource in our application which we will do in 
  -> src/main/java/com/navneet/todo/DBConfig.java







 */