# MusicIncStore
Sample music exhibition and ecommerce portal

This repository contains a sample application developed for learning purpose for exihibition and sale of audio songs sung by
various artists around the world.


App runtime environment:

OpenJDK 11
<br>
Payara 5.2021.7(community version)
<br>
Java EE 8
<br>
EclipseLink 2.7
<br>
MariaDB 10.3- the default MySQL on Debian based linux distributions

MariaDB JDBC driver jar has to be added to the libraries of Payara Server. The MariaDB connector jar to be placed is:

 mariadb-java-client-2.7.3 
 
From the command prompt in your OS run the following command:

./asadmin add-library <PATH_TO_YOUR_FOLDER/mariadb-java-client-2.7.3.jar

For example if you are using Linux/Mac or any other Unix like OS:

./asadmin add-library /home/jack/Downloads/mariadb-java-client-2.7.3.jar

where jack is the username.

For Windows please see below link:
https://godhani.me/setting-up-payara-development-environment/

To build:
mvn clean install

You can use any Java supported OS,IDE or application server for developing this project. I have used the below for my development environment:
<br>
<br>
			OS:    MX Linux 
<br>
<br>
			JDK:   OpenJDK 11 provided by MX Linux
<br>
<br>
			Database : Maria DB 10.3 - default MySQL version provided by MX Linux
<br>
<br>
			Java IDE:    Eclipse 2021-03
<br>
<br>
			REST Client for Testing API : POSTMAN
<br>
<br>
			Database IDE: SQLYog Community Edition - used via WINE
<br>
<br>
			Application Server: Payara 5.2021.7(community version)
	
If you wish to use MySQL instead of MariaDB then please do the following:
<br>
<br>
1.Please see below link and follow the instructions to setup JDBC connection pool and
JDBC resource.

https://blog.payara.fish/using-mysql-with-payara

Give the following details for JDBC connection pool and JDBC resource:

<h3>JDBC connection pool:</h3>
Datasource class name: org.mariadb.jdbc.MariaDbDataSource

Pool name: MusicIncStorePool

Resource Type:javax.sql.DataSource

Give these under properties for the JDBC connection pool:
serverName:localhost

databaseName:musicIncStore

URL: jdbc:mysql://localhost:3306/musicIncStore	

username: <your_db_user>
password:<your_db_password>

<h3>JDBC Resource</h3>

JNDI name: jdbc/musicIncStoreDB

Pool Name:MusicIncStorePool

<br>
<br>
2. EclipseLink is used as the JPA provider as that is bundled with Payara.Hence you will
find the following entry in persistence.xml:

```xml
	<property name="eclipselink.target-database" value="MySQL"/>
```

This is the equivalent of a dialect declaration in Hibernate.Since MariaDB is a fork of MySQL and compatible with it
this setting works well.

Application architecture/Technology Stack:

This application is built for an Angular frontend, hence consists of services to be provided in response to requests from Angular.

REST API layer: JAX-RS with Jersey(bundled with Payara). All JAX-RS resource classes are implemented as no interface view Local Stateless Session EJBs.

Service/DAO layers:Implemented as Local Stateless Session Beans.

MapStruct is used for DTO-JPA Entity mapping and vice-versa and Jackson is used for JSON marshalling/unmarshalling.