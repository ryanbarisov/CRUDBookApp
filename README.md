# CRUD Book Application

## Simple CRUD application - book shelf.

You can: mark book as read, add new book to shelf, remove book, search for some book on shelf.

## How to install?

### Using Intellij Idea
1. <code>git clone</code> to some directory and <code>cd</code> to it
2. Open the project in IntelliJ IDEA
3. Add local Tomcat configuration, e.g., using 8080 port on localhost
4. Add war:exploded artifact in deployment section
5. Run configured configuration and check <code>localhost:8080</code>

### Using Maven from the command line
1. <code>git clone</code> to some directory and <code>cd</code> to it
2. Launch <code>mvn tomcat7:run</code>
3. Application can then be seen at <code>localhost:8080/CRUDBookApp</code>

### Info

Books are stored in MySQL database.

Application Framework: Spring

Frontend: Spring MVC 

ORM: Hibernate

Application server: Tomcat 8.

Logging: log4j

For now log4j writes logging information in console and file <i>/tmp/logging.log</i> file.


Built and configured with Maven.