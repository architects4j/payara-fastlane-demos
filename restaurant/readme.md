# MicroProfile generated Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.
The generation of the executable jar file can be performed by issuing the following command

```
    mvn clean package
```
This will create an executable jar file **restaurant-microbundle.jar** within the _target_ maven folder. This can be started by executing the following command

```
    java -jar target/restaurant-microbundle.jar
```

To execute the tests
```
    curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "Jose", "description": "This is a description", "type": "BEVERAGE", "expires": "2030-12-03"}'   
```
## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.
Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.
More information on MicroProfile can be found [here](https://microprofile.io/)


## Samples