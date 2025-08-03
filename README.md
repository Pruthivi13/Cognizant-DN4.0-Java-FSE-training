# Cognizant DN4.0 Java FSE Training

This repository contains all the hands-on exercises, projects, and solutions developed during the Cognizant Digital Nurture 4.0 program for Java Full-Stack Engineering. The training covers a wide range of topics, from core Java concepts and PL/SQL to modern microservices architectures with Spring Boot and Spring Cloud.

## Repository Content Overview

The repository is structured chronologically by week, covering the following key areas:

*   **Week 1:** Foundational concepts including Data Structures, Algorithms, and core Software Design Patterns.
*   **Week 2:** Database programming with PL/SQL and Test-Driven Development (TDD) using JUnit 5 and Mockito.
*   **Week 3:** In-depth exploration of the Spring Framework, covering Spring Core (IoC, DI), AOP, Spring Data JPA, and building RESTful services with Spring Boot.
*   **Week 4:** Building secure REST APIs with Spring Security and JWT (JSON Web Tokens).
*   **Week 5:** Designing and implementing a microservices-based system using Spring Cloud, including a service registry (Eureka) and an API Gateway.

## Key Projects and Concepts

### Week 1: Data Structures, Algorithms & Design Patterns

This week focuses on the fundamentals of computer science and software design.

#### Data Structures & Algorithms

A series of projects demonstrating core data structures and their associated algorithms.

| Project | Description | Key Concepts |
|---|---|---|
| **InventoryManagementSystem** | A simple inventory system for adding, updating, and deleting products. | `HashMap` for efficient O(1) lookups. |
| **EmployeeManagementSystem** | A system for managing employee records using a fixed-size array. | Array-based CRUD operations, traversal. |
| **TaskManagementSystem** | A to-do list application to manage tasks using a custom linked list. | Singly Linked List (add, search, delete). |
| **LibraryManagementSystem** | Compares linear and binary search for finding books in a collection. | Linear Search, Binary Search (requires sorting). |
| **OrderSortingSystem** | Implements and compares different sorting algorithms for e-commerce orders. | Bubble Sort, Quick Sort. |
| **FinancialForecasting** | A tool to predict future investment value using a recursive approach. | Recursion for predictive modeling. |

#### Design Patterns

Implementations of common software design patterns in Java.

*   **Singleton:** `Logger.java` ensures only one instance of the logger is created across the application.
*   **Factory Method:** `DocumentFactory` provides an interface for creating `Document` objects, with concrete factories (`WordDocumentFactory`, `PdfDocumentFactory`) deciding which class to instantiate.
*   **Adapter:** The `PayPalAdapter` and `StripeAdapter` allow incompatible payment gateway APIs to work together under a common `PaymentProcessor` interface.
*   **Decorator:** `NotifierDecorator` subclasses (e.g., `SMSNotifierDecorator`) dynamically add new functionalities (notification channels) to a base `EmailNotifier` object.
*   **Strategy:** `PaymentContext` uses different payment strategies (`CreditCardPayment`, `PayPalPayment`) interchangeably to process payments.
*   **Observer:** The `StockMarket` (subject) notifies multiple observers (`MobileApp`, `WebApp`) of state changes (stock price updates).
*   **Builder:** A fluent API for constructing complex `Computer` objects step-by-step, separating construction from representation.
*   **Proxy:** `ProxyImage` acts as a surrogate for `RealImage`, controlling access and implementing lazy loading of images from a remote server.
*   **Command:** Encapsulates requests (`LightOnCommand`, `LightOffCommand`) as objects, allowing for parameterization and queuing of requests.
*   **MVC (Model-View-Controller):** A simple `Student` application separating data (Model), presentation (View), and user input logic (Controller).
*   **Dependency Injection:** `CustomerService` receives its `CustomerRepository` dependency via its constructor, promoting loose coupling and testability.

### Week 2: PL/SQL and TDD

This week introduces database scripting and modern testing practices.

*   **PL/SQL:** A series of SQL scripts (`.sql` files) covering procedures, functions, triggers, cursors, and packages for performing database operations like interest calculation, data validation, and auditing.
*   **TDD with JUnit & Mockito:** Maven-based projects demonstrating unit testing principles. This includes basic assertions, test lifecycle management (`@Before`, `@After`), parameterized tests with `@ValueSource`, and extensive use of Mockito to mock dependencies in service-layer tests.

### Week 3 & 4: Spring, Spring Boot & Security

This section covers building robust, data-driven web applications using the Spring ecosystem.

#### `orm-learn` (Spring Data JPA)

A console-based Spring Boot application demonstrating powerful database operations with Spring Data JPA.

*   **Repository Queries:** Implements custom queries using both JPA method names (e.g., `findByNameContaining`) and the `@Query` annotation.
*   **Data Retrieval:** Fetches and filters `Stock` and `Country` data from a MySQL database based on various criteria.
*   **Entity Relationships:** Manages many-to-one (`Employee` to `Department`) and many-to-many (`Employee` to `Skill`) relationships.
*   **Dynamic Queries:** Uses the JPA Criteria API in `ProductService` to build type-safe queries for filtering products.

#### `spring-learn` (Spring REST & Security)

A Spring Boot project demonstrating the creation of RESTful web services with security.

*   **REST Controllers:** Exposes endpoints for `Country`, `Employee`, and `Department` data.
*   **XML Configuration:** Demonstrates loading Spring beans from XML files (`country.xml`, `employee.xml`) using `ClassPathXmlApplicationContext`.
*   **Exception Handling:** Implements a custom `CountryNotFoundException` and returns a structured 404 response.
*   **JWT Security:** Secures the API using Spring Security and JSON Web Tokens.
    *   `AuthenticationController`: Generates a JWT upon successful basic authentication.
    *   `JwtAuthorizationFilter`: A custom filter that validates the JWT from the `Authorization` header on subsequent requests.
    *   `SecurityConfig`: Configures public/private endpoints and wires the custom JWT filter into the security chain.

### Week 5: Microservices with Spring Cloud

This project demonstrates a complete microservices architecture.

*   **`eureka-discovery-server`**: The service registry where all microservices register themselves. It acts as a phone book for the services.
*   **`api-gateway`**: A single entry point for all client requests. It uses Spring Cloud Gateway to route requests to the appropriate microservice based on the path. It also includes a global `LogFilter` to log all incoming requests.
*   **Microservices (`account-service`, `loan-service`, `greet-service`)**: Independent, deployable services that perform specific business functions. Each service is a Spring Boot application configured as a Eureka client to register with the discovery server.

## How to Run the Projects

### Prerequisites

*   Java 17 or later
*   Apache Maven
*   A MySQL server (for the `orm-learn` project)

### Week 1: Core Java Projects

These are standard Java projects without external dependencies.
1.  Navigate to a specific project directory (e.g., `week 1/Week 1- Design Patterns and Principles/AdapterPatternExample/`).
2.  Compile the Java files: `javac *.java` or `javac */*.java` if files are in subpackages.
3.  Run the main application class: `java Main` or `java <package>.Main`.

### Weeks 3, 4, 5: Spring Boot & Maven Projects

All Spring projects use the Maven wrapper, which handles downloading the correct Maven version.

#### Running a Standard Spring Boot Application (e.g., `springboot-demo`, `spring-learn`)

1.  Navigate to the project's root directory (e.g., `Week 3/springboot-demo/springboot-demo/`).
2.  Execute the Maven wrapper to run the application:
    *   On macOS/Linux: `./mvnw spring-boot:run`
    *   On Windows: `mvnw.cmd spring-boot:run`
3.  The application will start on the port specified in its `application.properties` file (e.g., `http://localhost:8080`).

#### Specific Project Instructions

*   **`orm-learn`:**
    1.  Ensure your MySQL server is running.
    2.  Create a database named `ormlearn`.
    3.  Update the database URL, username, and password in `Week 3/orm-learn/src/main/resources/application.properties`.
    4.  Run the application. The `TestRunner` class will execute all the data access tests on startup and print results to the console.

*   **`springboot-demo`:**
    1.  This project uses an in-memory H2 database, so no external setup is needed.
    2.  Once running, you can access the H2 console at `http://localhost:8080/h2-console` (use JDBC URL: `jdbc:h2:mem:librarydb`).
    3.  Use an API client like Postman or the provided `test-books.http` file to interact with the `/books` endpoints.

*   **`LibraryManagement` (Non-Web Application):**
    1.  Navigate to `Week 3/LibraryManagement/LibraryManagement/`.
    2.  Run the application using the Maven `exec` plugin: `mvn clean compile exec:java`.

*   **Microservices Project (Week 5):**
    1.  Start the services in the following order:
        *   `eureka-discovery-server`
        *   `api-gateway`
        *   `account-service`, `loan-service`, `greet-service` (order doesn't matter for these)
    2.  Once all services are running, you can access them through the API Gateway at `http://localhost:9090`. For example, a request to `http://localhost:9090/greet-service/greet` will be routed to the greet service.

# 🚀 Cognizant DN4.0 Java FSE – Week 6

This directory contains the code assignments and exercises for **Week 6** of the **Cognizant DN4.0 Java Full-Stack Engineering Training Program**. The focus of this week is on building and testing **RESTful APIs using Spring Boot**, implementing **service and persistence layers**, and managing **exception handling** in a structured way.

---

## 📚 Topics Covered

- ✅ Building RESTful APIs with Spring Boot
- ✅ Creating Service and Repository layers
- ✅ Handling exceptions using `@ControllerAdvice`
- ✅ CRUD operations with Spring Data JPA
- ✅ Testing with JUnit and Mockito
- ✅ API response structure and HTTP status codes

---

## 📁 Project Structure

Week 6/ ├── src/ │   ├── main/ │   │   ├── java/ │   │   │   └── com/example/...     # Java packages (controllers, services, models, repos) │   │   └── resources/ │   │       └── application.properties  # App config │   └── test/ │       └── java/                  # Unit and integration test classes ├── pom.xml / build.gradle         # Maven or Gradle build file └── README.md                      # This file



## ⚙️ Build & Run Instructions

### 1. Clone the repository
```bash
git clone https://github.com/Pruthivi13/Cognizant-DN4.0-Java-FSE-training.git
cd Cognizant-DN4.0-Java-FSE-training/Week\ 6

2. Build the project

Using Maven:

./mvnw clean install

Using Gradle:

./gradlew clean build

3. Run the application

Using Maven:

./mvnw spring-boot:run

Using Gradle:

./gradlew bootRun


---

🧪 Running Tests

Using Maven:

./mvnw test

Using Gradle:

./gradlew test


---

🔗 API Access

Once the app is running, access your REST APIs at:

http://localhost:8080/api/{resource}

Use tools like Postman, cURL, or your browser to test endpoints.


---

✅ Key Features

🔸 RESTful CRUD operations with proper routing

🔸 Use of @RestController, @Service, and @Repository

🔸 Exception handling with custom error messages and HTTP status codes

🔸 Clean code with separation of concerns (MVC structure)

🔸 Mock-based unit testing with JUnit and Mockito



---

🧰 Tech Stack

Java 11+

Spring Boot

Spring Data JPA

H2/MySQL (based on your configuration)

JUnit 5, Mockito

Maven / Gradle
```

# 🚀 Cognizant DN4.0 Java FSE – Week 7

This directory contains assignments and practice code for **Week 7** of the **Cognizant DN4.0 Java Full-Stack Engineering Training Program**. This week's focus is on **building Spring Boot REST APIs with advanced exception handling**, **unit testing**, and **layered architecture best practices**.

---

## 📚 Topics Covered

- ✅ REST API development using Spring Boot
- ✅ Global and custom exception handling with `@ControllerAdvice`
- ✅ CRUD operations via `@RestController`
- ✅ Service and repository layer implementation
- ✅ Unit testing with JUnit 5 and Mockito
- ✅ Layered architecture (Controller → Service → Repository)

---

## 📁 Project Structure



Week 7/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/...     # Controllers, services, models, exceptions, repositories
│   │   └── resources/
│   │       └── application.properties  # App configuration
│   └── test/
│       └── java/                      # Unit test classes
├── pom.xml / build.gradle             # Maven or Gradle build file
└── README.md                          # This file

`

> 🔍 Make sure to update package names and paths based on your codebase.

---

## ⚙ Build & Run Instructions

### 1. Clone the repository
bash
git clone https://github.com/Pruthivi13/Cognizant-DN4.0-Java-FSE-training.git
cd Cognizant-DN4.0-Java-FSE-training/Week\ 7
`

### 2. Build the project

#### Using Maven:

bash
./mvnw clean install


#### Using Gradle:

bash
./gradlew clean build

### 3. Run the application

#### Using Maven:

bash
./mvnw spring-boot:run


#### Using Gradle:

bash
./gradlew bootRun


---

## 🔗 API Access

Access REST endpoints at:


http://localhost:8080/api/{resource}


> Use **Postman** or **curl** to test your endpoints.

---
## ✅ Key Features

* 🔸 RESTful endpoints mapped with `@RestController`
* 🔸 Proper use of HTTP methods (GET, POST, PUT, DELETE)
* 🔸 Service layer handles business logic cleanly
* 🔸 Repository layer abstracts data persistence
* 🔸 Custom exceptions and centralized error responses via `@ControllerAdvice`
* 🔸 Unit testing with mocked dependencies using **Mockito**

---

## 🧪 Testing Instructions

### Run Tests with:

#### Maven:

bash
./mvnw test


#### Gradle:
bash
./gradlew test


* ✅ Tests for service methods and controller endpoints
* ✅ Validation of exception scenarios

---

## 🧰 Tech Stack

* **Java 11+**
* **Spring Boot**
* **Spring Data JPA**
* **JUnit 5**
* **Mockito**
* **H2 / MySQL**
* **Maven / Gradle**

---

# 🚀 Cognizant DN4.0 Java FSE – Week 8

## Overview

The files within this directory are used to demonstrate various Git operations, including branching, merging, and handling merge conflicts.

## Directory Structure


Week 8/
├── Output/
└── git/
    ├── branchFile.txt
    ├── hello.xml
    ├── hello.xml.orig
    ├── welcome.txt
    └── log/
        └── info.txt


### File Descriptions

*   **git/**: The primary working directory for the Git exercises.
*   **git/hello.xml**: The final version of an XML file after a merge.
*   **git/hello.xml.orig**: A backup file automatically created by Git during a merge conflict resolution. It shows the original state of the conflict between the master and GitWork branches.
*   **git/branchFile.txt**: A text file added specifically in a new branch named GitNewBranch to demonstrate branching workflows.
*   **git/welcome.txt**: A simple text file under version control.
*   **git/log/info.txt**: A file inside a subdirectory to show how Git tracks nested file structures.
*   **Output/**: An empty directory, likely intended for storing outputs from Git commands.

