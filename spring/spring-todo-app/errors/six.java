/*

when you run the application , we get error like this 

org.postgresql.util.PSQLException: FATAL: Ident authentication failed for user "postgres"

-> this error is because of the authentication method used by postgres database
-> by default postgres uses ident authentication method which is not compatible with our application
-> so we need to change the authentication method to md5 in postgres configuration file
-> to do that we need to edit the pg_hba.conf file which is located in /var/lib/pgsql/data/pg_hba.conf
-> we need to change the authentication method for local connections to md5 like this

//first enter postgres as system user 
sudo -u postgres psql

// set password for postgres user
ALTER USER postgres WITH PASSWORD 'your_password';

// exit -> /q

// now we need to edit the hba file
sudo nano /var/lib/pgsql/data/pg_hba.conf

find the line -> local   all   all   peer
and change it to -> local   all   all   md5

also find localhost and ::1 and change the authentication method to md5

// then restart the postgres service
sudo systemctl restart postgresql

// checking the connection again
psql -U postgres -d todo_app -h localhost
// if you are able to connect to the database then it means that the authentication method is 
// changed successfully and now you can run your application without any error







 */