# Population

**Configure database parameters**

Configure database parameters in the following files:
- pom.xml
- src/main/resources/hibernate.cfg.xml

**Migrate database**

To migrate the database automatically you can use the flyway plugin with the following command:

```
mvn flyway:migrate
```
The .sql files are located in src/main/resources/db/migration

**Execution with wildfly**

To install the dependencies and run the application with wildfly you can run the following command:

```
mvn clean install && mvn wildfly:run
```