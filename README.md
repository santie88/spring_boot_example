# spring_boot_practice

This is a simple app which shows how to:

* Initialize an Spring environment
* Read a properties file
* Create an endpoint
* Manage dependency injection with annotations
* Choose between different environments by program arguments
* Use the @Configuration annotation to initialize beans
* Schedule a Job
* Web services with JAX-RX
* Object Mapping with Jackson
* Document the API with swagger
* Spring Data to connect with MongoDB 
* DockerFile to create a Microservice.

* @Deprecated classes showing different ways of doing things, for example connecting with mongoDB using Mongo Java Driver and diffent ways to intantiate Beans dependieng on @Conditions

How to run it:

* If you want to use production environment you should add -Dspring.profiles.active=prod to the starter class, by default it runs in local environment
* Check localhost:8080/swagger-ui.html (8082 for 'prod' profile)
