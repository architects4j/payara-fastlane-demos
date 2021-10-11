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

To execute the tests:

```
curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "water", "description": "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.", "type": "BEVERAGE", 
"expires": "2025-12-03", "ingredients": [{"name": "water", "unit": "L", "quantity": 2}]}'

curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "coconut-water", "description": "Coconut water is the clear liquid inside coconuts.", "type": "BEVERAGE", 
"expires": "2025-12-03", "ingredients": [{"name": "coconut water", "unit": "L", "quantity": 1}]}'


curl --location --request GET 'http://localhost:8080/restaurants/water'

curl --location --request GET 'http://localhost:8080/restaurants'
```

Validations tests:

```
curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"description": "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.", "type": "BEVERAGE", "expires": "2030-12-03"}'

curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "water", "description": "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.", "type": "BEVERAGE", "expires": "2000-12-03"}'

curl --location --request POST 'http://localhost:8080/restaurants' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "w", "description": "Water appears as a clear, nontoxic liquid composed of hydrogen and oxygen, essential for life.", "type": "BEVERAGE", "expires": "2025-12-03"}'
```



## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.
Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.
More information on MicroProfile can be found [here](https://microprofile.io/)

## Open API

When the application is running, you can access the URL http://localhost:8080/openapi/ to get the open API result.

Let's go to the Postman to test your API; the first step is to import the API from the URL that we already showed.

Let's go to the Postman to test your API. The first step is to install the application itself where it has support for Linux, Windows or Mac OS. When we installed the Postman application, [the next step is to import the API from the Open API URL](https://learning.postman.com/docs/integrations/available-integrations/working-with-openAPI/).

It works like magic, [don't forget to set the variables inside Postman](https://learning.postman.com/docs/sending-requests/variables/).

