# Spring Boot micro-services example
Example based on the following technologies:

* Java
* Spring Framework
* Spring Boot
* Spring Cloud
* Netflix Eureka

Versions of the technologies have used:

|Technology|Version|
|----------|-------|
|Java SE|1.8|
|Spring Boot|1.5.21.RELEASE|
|Spring|4.3.24.RELEASE|
|Spring Cloud|Edgware.SR6|

## Starting

You need to start all services in the following order:
1. config-server
  Ensure that the following message appears in log:
  ```
  Started ConfigServer in 4.441 seconds (JVM running for 5.139)
  ```
2. netflix-eureka-server
  Ensure that the following message appears in log:
  ```
  Started NetflixEurekaServerApplication in 4.92 seconds (JVM running for 5.541)
  ```
  Wait a bit, and ensure that `config-server` has successfully registered in Eureka.

  See for the following messages in `config-server`'s log:
  ```
  DiscoveryClient_CONFIG_SERVER/your_pc_name:config_server:48888: registering service...
  DiscoveryClient_CONFIG_SERVER/your_pc_name:config_server:48888 - registration status: 204
  ```
  See for the following messages in `netflix-eureka-server`'s log:
  ```
  Registered instance CONFIG_SERVER/your_pc_name:config_server:48888 with status UP (replication=false)
  ```
3. Now let's start two micro-services
  See for the following messages in services' logs:
  ```
  DiscoveryClient_MICROSERVICE-ONE/your_pc_name:microservice-one:9991: registering service...
  DiscoveryClient_MICROSERVICE-ONE/your_pc_name:microservice-one:9991 - registration status: 204
  Started MicroServiceOneApplication in 4.314 seconds (JVM running for 4.98)
  ```
  ```
  DiscoveryClient_MICROSERVICE-TWO/your_pc_name:microservice-two:9992: registering service...
  DiscoveryClient_MICROSERVICE-TWO/your_pc_name:microservice-two:9992 - registration status: 204
  Started MicroServiceTwoApplication in 4.477 seconds (JVM running for 5.105)
  ```
  And in `netflix-eureka-server`'s log:
  ```
  Registered instance MICROSERVICE-ONE/your_pc_name:microservice-one:9991 with status UP (replication=false)
  Registered instance MICROSERVICE-TWO/your_pc_name:microservice-two:9992 with status UP (replication=false)
  ```
4. Now we can use both services via Feign clients.
  ```
  GET http://localhost:9991/hello
  ```
  will show you greeting from this first service, and
  ```
  GET http://localhost:9991/hello2
  ```
  will show you greeting from this Service 2 via Feign-client.

  And vise versa:

  ```
  GET http://localhost:9992/hello
  ```
  will show you greeting from this second service, and
  ```
  GET http://localhost:9992/hello1
  ```
  will show you greeting from this Service 1 via Feign-client.

### Useful Links
* [Spring Cloud Netflix Eureka - The Hidden Manual](https://blog.asarkar.org/technical/netflix-eureka/)
* [Eureka, Zuul, and Cloud Configuration - Local Development](http://engineering.pivotal.io/post/local-eureka-zuul-cloud_config-with-spring/) (Spring Boot 2)

##### Baeldung's blog
* [Spring Cloud Configuration](https://www.baeldung.com/spring-cloud-configuration)
* [Spring Cloud Netflix Eureka](https://www.baeldung.com/spring-cloud-netflix-eureka)
* [spring Cloud Bootstrapping](https://www.baeldung.com/spring-cloud-bootstrapping)
