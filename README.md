# Flight Search API

## Table of Contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
  - [Used Technologies](#used-technologies)
  - [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Endpoints](#endpoints)
- [Schemas](#schemas)
- [Search Feature](#search-feature)
- [Authentication](#authentication)
- [Scheduled Job for MockAPI](#scheduled-job-for-mockapi)

## Introduction
This project is a Backend API with a flight search feature developed using Spring Boot. Users can search for departure and return flight information. New flight informations are adding every day.

## Getting Started
Before using the application, it is necessary to pay attention to the technologies used.

### Used Technologies
List of technologies used in the project:

- Java 17
- Spring Boot
- MySQL
- Hibernate
- JWT Token Authentication
- Swagger UI (API documentation)
- Postman
- Git (for Version control)

### Prerequisites
- Java version should be 17. 
- At least one relational database such as MySQL. (In this project I prefer use MySQL).
- Git should be installed.

First clone repositories to your machine:
```bash
git clone https://github.com.git
```
Then, Configure database options (for .yml):
```bash
  datasource:
    url: jdbc:mysql://localhost:3306/database_name
    username: database_username
    password: database_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```
Finally, build and run the project (in project directory):
```bash
./mvnw spring-boot:run
```

## Project Structure
Overview of the directory structure :

- **src/main/java:** Java source code for the application.
  - **com.amadeus.yusufcankorkmaz.casestudy.searchflight** The main package for the application.
    - **config:** Contains configuration files.
    - **controller:** Contains API controllers.
    - **dto:** Contains DTO (Data Transfer Object) classes.
      - **request:** Contains dtos for spesific request.
      - **response:** Contains dtos for spesific response.
    - **entity:** Contains model classes.
      - **user:** Contains user and role model.
    - **exception:** Contains project related exceptions.
    - **mockapi:** Contains mock flight data generation.  
    - **repository:** Contains database repository interfaces.
    - **security:** Contains auth filter and userdetail implementation.      
    - **service:** Contains business logic and services.
      - **schedule:** Contains scheduled job service.
      - **security:** Contains jwt services.

## Endpoints
Here, the available endpoints in the API:

<img width="1169" alt="endpoints" src="https://github.com/battalmm/deneme/assets/122535629/67e5b71b-0f2d-488d-8b7e-198a810c21fb">


## Schemas
Here, all dto schemas used in the project:

<img width="1127" alt="schema_1" src="https://github.com/battalmm/deneme/assets/122535629/f53222b8-5964-495f-afb5-f169c5e3d733">
<img width="1119" alt="schema_2" src="https://github.com/battalmm/deneme/assets/122535629/4fc6f7ec-123a-4b31-89dc-56593818cbe7">

## Search Feature
When the application start default airports and flights will be create and saced to database. This is an example for input and output flight search feature. If only departure information is given, only the departure flights will list. If the return information is given too, the departure and return flights will list.

1. One way flight:

<img width="1243" alt="oneway" src="https://github.com/battalmm/deneme/assets/122535629/88129286-f721-4084-b8ff-b0d3a9e5871c">

2. Round trip:

<img width="1245" alt="roundtrip" src="https://github.com/battalmm/deneme/assets/122535629/c3f32b86-ab37-4436-8886-08dc3f8651e7">

## Authentication
Authentication and security are provided with Json Web Token in the project. When the application runs, an admin user will be created by default.
```bash
Email: admin@admin.com
Password: admin
```
Except for login, signup and swagger related endpoints, it is necessary to be authenticated in order to use other endpoints. To use other endpoints, use the JWT token given to you after logging in. This token must be added to the Authorization section of the http request header. It looks like this:

```bash
Bearer eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDM0NDQ2NTMsImlhdCI6MTcwMzQzODY1Mywic3ViIjoiYWRtaW5AYWRtaW4uY29tIn0.uQbbDwU7vdTWGD6JedfZ9PUpSIasimm7jhKaqrHx4Uc
```

## Scheduled Job (MockAPI)
A scheduled task was added considering that the application retrieves flight information from a mock API. This process is set to run once a day. It receives and records flight data every day.

```bash
@Scheduled(cron = "0 0 0 * * *")
```
