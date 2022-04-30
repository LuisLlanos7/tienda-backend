# Hulk Cardex System - Hulk-Store (Inventory) BACKEND

Hulk Store is a web app for maintaining a product's inventory. It was developed by Luis Espinosa Llanos and for the backend it was used the following technologies and tools: 

<table style="width:100%">
  <tr>
    <td>
  	Core	
    </td>
    <td>
  	Java 1.8, Spring Boot 2 (Spring Framework), Data JPA, Hibernate, Loombok, Jackson Databinding
    </td>
  </tr>
  <tr>
    <td>
  	Testing	
    </td>
    <td>
  	Junit 5, Mockito, Sonar Lint, SonarQube
    </td>
  </tr>
  <tr>
    <td>
  	Server	
    </td>
    <td>
  	Apache Tomcat Embebido (Spring Boot)
    </td>
  </tr>
  <tr>
    <td>
  	Executable	
    </td>
    <td>
  	Jar
    </td>
  </tr>
</table>

It was written using the best practices for instance, a controller, service and repository layer approach, code reusing, unit tests, a good condition coverage, dependecy injection, design patterns and more... 

## Where is the FrontEnd?
There is another repository available with the frontend code. You can find it here:
https://github.com/LuisEspinosa7/tienda-frontend

## Video
A video exposing the functionality of the proyect in local environment on a Desktop screen.

https://youtu.be/YXhbBld822g

## Development Resources
I provide the following resources:

<table style="width:100%">
  <tr>
    <td>
  	Database SQL Backup	
    </td>
    <td>
	In the db folder
    </td>
  </tr>
  <tr>
    <td>
  	Postman Collection	
    </td>
    <td>
	In the postman folder
    </td>
  </tr>
</table>

## Pictures
Some pictures of the project on a local environment respectively:

<table style="width:100%">
  <tr>
    <td>
  		<img width="450" alt="Eclipse" src="https://user-images.githubusercontent.com/56041525/166087937-2b0b65ad-a2d0-4649-91d6-6e4984059d4a.PNG">
	  </td>
    <td>
  	<img width="450" alt="PostMan" src="https://user-images.githubusercontent.com/56041525/166087955-38327acc-5b17-487c-b524-e63e3d4941f9.PNG">
    </td>
  </tr>
</table>

<table style="width:100%">
  <tr>
    <td>
  		<img width="450" alt="PostgreSQL" src="https://user-images.githubusercontent.com/56041525/166087969-de9325f0-1a54-481e-b8d7-eade2c231c33.PNG">
	  </td>
    <td>
	<img width="450" alt="Eclipse" src="https://user-images.githubusercontent.com/56041525/166088468-1496317f-4c78-45be-83aa-11ae778715bd.png">
    </td>
  </tr>
</table>

## Installation

This proyect should be installed using the following command:
```bash
mvn clean install
```

## Usage
In the target folder you will find the Jar archive, so please use the following command:

```bash
java -jar NAME_OF_THE_JAR.jar
```

## Tests and coverage
In the project you will find the tests report with Jacoco. But you should scan it with SonarQube.


## Contributing
This proyect is quite simple, and is part of my personal portfolio, so it is not intended to receive contributions.


## License
It is free.
