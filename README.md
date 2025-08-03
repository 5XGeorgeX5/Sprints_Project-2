# Library Management System - Spring Boot Project

## Project Overview
This is a Spring Boot application demonstrating various core Spring concepts including dependency injection, configuration management, component scanning, and JPA data access. The project implements a simple library management system with book CRUD operations.

## Here is the Repo link for clear commits:
https://github.com/5XGeorgeX5/Sprints_Project-2.git

## Repository Structure
The project is structured as follows:

```bash
Directory structure:
└── 5xgeorgex5-sprints_project-2/
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── team2/
    │   │   │           └── library/
    │   │   │               ├── LibraryApplication.java
    │   │   │               ├── books/
    │   │   │               │   ├── BookModel.java
    │   │   │               │   ├── BookRepository.java
    │   │   │               │   └── BookService.java
    │   │   │               ├── common/
    │   │   │               │   └── controller/
    │   │   │               │       ├── DevController.java
    │   │   │               │       └── LibraryController.java
    │   │   │               ├── config/
    │   │   │               │   └── LibraryConfig.java
    │   │   │               ├── greeting/
    │   │   │               │   ├── controller/
    │   │   │               │   │   └── GreetingController.java
    │   │   │               │   └── service/
    │   │   │               │       ├── EveningGreetingService.java
    │   │   │               │       ├── GreetingService.java
    │   │   │               │       └── MorningGreetingService.java
    │   │   │               └── notifications/
    │   │   │                   ├── controller/
    │   │   │                   │   └── NotificationController.java
    │   │   │                   └── service/
    │   │   │                       ├── EmailNotificationService.java
    │   │   │                       ├── NotificationService.java
    │   │   │                       └── SmsNotificationService.java
    │   └── resources/
    │       ├── application-dev.yml
    │       ├── application-prod.yml
    │       └── application.properties
    │       └── .mvn/
        └── wrapper/
            └── maven-wrapper.properties
```


## Technical Specifications
- **Java Version**: 17
- **Spring Boot Version**: 3.5.4
- **Build Tool**: Maven
- **Database**: H2 in-memory database
- **Dependencies**:
  - Spring Web
  - Spring Data JPA
  - H2 Database
  - Spring Boot Test

## Project Requirements Implementation

### Core Setup & Anatomy
- Initialized Spring Boot project with Web and JPA dependencies
- Created `@SpringBootApplication` main class with custom component scanning
- Exposed `/health` endpoint returning "OK"

### Dependency Injection Basics
- Implemented `GreetingService` interface with two implementations:
  - `MorningGreetingService` (marked as `@Primary`)
  - `EveningGreetingService` (marked with `@Qualifier("evening")`)
- Demonstrated all three injection types in `GreetingController`:
  - Constructor injection
  - Setter injection
  - Field injection

### Configuration & Profiles
- Externalized configuration in:
  - `application.properties` (main configuration)
  - `application-dev.yml` (development profile)
  - `application-prod.yml` (production profile)
- Created `LibraryConfig` with `@ConfigurationProperties` binding
- Profile activation via `spring.profiles.active` property

### Component Scanning & Stereotypes
- Organized packages under `com.team2.library`
- Used `@ComponentScan` with exclude filter to prevent loading of `DevController`
- Verified exclusion with integration test

### Advanced Dependency Injection
- Created two `NotificationService` implementations:
  - `EmailNotificationService` (marked as `@Primary`)
  - `SmsNotificationService` (marked with `@Qualifier("sms")`)
- Injected both into `NotificationController` with endpoints:
  - `/notify/email`
  - `/notify/sms`

### Book Management (CRUD Operations)
- Implemented `BookModel` entity with JPA annotations
- Created `BookRepository` extending `JpaRepository`
- Implemented `BookService` with full CRUD operations

## API Endpoints

### Library Info
- `GET /health` - Returns "OK" status
- `GET /library-info` - Returns library configuration details

### Greeting Services
- `GET /greet/morning` - Returns morning greeting
- `GET /greet/evening` - Returns evening greeting
- `GET /greet/default` - Returns default (primary) greeting

### Notification Services
- `GET /notify/email` - Sends email notification
- `GET /notify/sms` - Sends SMS notification

### Book Management
- `GET /api/books/` - Returns all books 
- `GET /api/books/{id}` - Return book with selected id 
- `GET /api/books/author/{author}` - Return books with selected author
-  `GET /api/books/search` - Return books with selected keyword
- `POST /api/books/` - Create a book 
- `PUT /api/books/{id}` - Update a book with selected id
- `DELETE /api/books/{id}` - Delete a book with selected id

## Running the Application

1. **Prerequisites**:
   - Java 17 JDK installed
   - Maven installed (or use provided Maven wrapper)

2. **Running with Maven**:
   ```bash
   ./mvnw spring-boot:run

3. **Profile Activation**:
   - Default profile: dev (set in application.properties)
   - To run with dev profile:
   ```bash
   ./mvnw spring-boot:run -Dspring-boot.run.profiles=prod

4. **Accessing the Application**:
    - Default port: 8080

    - H2 Console: http://localhost:8080/h2-console

      - JDBC URL: jdbc:h2:mem:myDB

      - Username: sa

      - Password: (empty)
