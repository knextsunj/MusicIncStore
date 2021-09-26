# MusicIncStore
Sample music exhibition and ecommerce portal

This repository contains a sample application developed for learning purpose for exihibition and sale of audio songs sung by
various artists around the world.


App runtime environment:

OpenJDK 11
<br>
Apache Tomcat 9.0.37
<br>
Spring 5
<br>
Hibernate 5
<br>
MariaDB 10.3- the default MySQL on Debian based linux distributions

The datasource is taken from JNDI via Tomcat. Tomcat by default does not have a feature to encrypt passwords for databases in it's configuration files. Hence it has to be manually setup.I have used a readily available solution in github:

				https://github.com/k-tamura/encrypt-db-password
				

I forked the above repository to github, followed the instructions from the original repository and built the jar. Then placed the jar in lib folder of Tomcat.The 
name of the built jar is - encrypt-db-password-1.0.0.jar

The resulting datasource configuration can be added in context.xml file of Tomcat, like below :

Example Datasource configuration:
<br>
Please see sample context.xml provided in this repository.

Also place the MariaDB JDBC driver jar in the lib folder of Tomcat. The MariaDB connector jar to be placed is:

 mariadb-java-client-2.7.3 

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
			Application Server: Apache Tomcat 9.0.37
	
If you wish to use MySQL instead of MariaDB then please do the following:
<br>
<br>
1.Place the MySQL JDBC driver jar in the ib folder of Tomcat
<br>
<br>
2.Under src/main/resources open app.properties and update the hibernate dialect key:
Replace 
<br>
hibernate.dialect.value = org.hibernate.dialect.MariaDB103Dialect
<br>
with 
<br>
hibernate.dialect.value = org.hibernate.dialect.MySQL8Dialect(MySQL 8)
<br>
or
<br>
hibernate.dialect.value = org.hibernate.dialect.MySQL57Dialect(MySQL 5.7)
<br>
<br>
3. Update the JDBC driver name in the tomcat JNDI datasource configuration
   in context.xml. See sample context.xml for more details.
<br>
<br>

Application architecture/Technology Stack:

This application is built for an Angular frontend, hence consists of services to be provided in response to requests from Angular.

REST API layer: Spring MVC. 

Service/DAO layers:Spring POJO beans

MapStruct is used for DTO-JPA Entity mapping and vice-versa and Jackson is used for JSON marshalling/unmarshalling.

