# # Cognizant DN4.0 Java FSE Training

This repository contains all the hands-on exercises, projects, and solutions developed during the Cognizant Digital Nurture 4.0 program for Java Full-Stack Engineering. The training covers fundamental and advanced topics in Java, from data structures to modern Spring Boot applications.

## Repository Structure

The projects are organized into weekly directories, reflecting the structure of the training program.

-   **`Week 1- Algoritms and Data Structures/`**: Contains foundational exercises on common data structures and algorithms.
-   **`week 1/Week 1- Design Patterns and Principles/`**: Includes implementations of various creational, structural, and behavioral design patterns.
-   **`Week 3/`**: Focuses on the Spring Framework, including Core concepts, AOP, Data JPA, and Spring Boot.

## Key Concepts and Projects

This repository provides practical examples of the following topics:

### Week 1: Data Structures and Algorithms

A series of small, focused projects demonstrating core data structures and algorithms.

| Project                      | Description                                                                               | Key Concepts                               |
| ---------------------------- | ----------------------------------------------------------------------------------------- | ------------------------------------------ |
| **EcommerceSearchSystem**      | Implements and compares search algorithms for a product catalog.                          | Linear Search, Binary Search               |
| **EmployeeManagementSystem**   | A system for managing employee records using a fixed-size array.                          | Array-based CRUD operations, traversal     |
| **FinancialForecasting**       | A tool to predict future value using recursion.                                           | Recursion, Tail Recursion Optimization     |
| **InventoryManagementSystem**  | A simple inventory system for adding, updating, and deleting products.                    | `HashMap` for efficient lookups            |
| **LibraryManagementSystem**    | A library system to search for books by title.                                            | Linear Search, Binary Search               |
| **OrderSortingSystem**         | Compares the performance and implementation of different sorting algorithms for orders.   | Bubble Sort, Quick Sort                    |
| **TaskManagementSystem**       | A to-do list application to manage tasks.                                                 | Singly Linked List (add, search, delete)   |

### Week 1: Design Patterns

Implementations of common software design patterns in Java.

-   **Singleton**: `Logger.java` ensures only one instance of the logger is created.
-   **Factory Method**: `DocumentFactory` and its subclasses create different types of documents (`Word`, `PDF`, `Excel`).
-   **Builder**: `Computer.java` provides a fluent API for constructing complex `Computer` objects.
-   **Adapter**: `PayPalAdapter` and `StripeAdapter` unify different payment gateway APIs under a common `PaymentProcessor` interface.
-   **Decorator**: `NotifierDecorator` and its subclasses dynamically add notification channels (SMS, Slack) to a base email notifier.
-   **Proxy**: `ProxyImage` provides a surrogate for `RealImage` to control access and implement lazy loading.
-   **Strategy**: `PaymentContext` uses different payment strategies (`CreditCardPayment`, `PayPalPayment`) interchangeably.
-   **Observer**: `StockMarket` (subject) notifies multiple observers (`MobileApp`, `WebApp`) of price changes.
-   **Command**: `RemoteControl` encapsulates requests (`LightOnCommand`, `LightOffCommand`) as objects.
-   **MVC (Model-View-Controller)**: A simple `Student` application separating data (Model), presentation (View), and logic (Controller).
-   **Dependency Injection**: `CustomerService` receives its `CustomerRepository` dependency via its constructor, promoting loose coupling.

### Week 3: Spring Framework, Data JPA, and Spring Boot

Advanced projects using the Spring ecosystem for building enterprise-grade applications.

#### `orm-learn`

A comprehensive Spring Boot application demonstrating Spring Data JPA and Hibernate for database operations. It connects to a MySQL database to perform various queries and manage complex entity relationships.

**Features:**
-   **Basic CRUD**: Demonstrates standard repository operations.
-   **Custom Queries**: Uses `@Query` annotation and JPA query methods to fetch `Country` and `Stock` data based on specific criteria (e.g., `findByNameContaining`, `findByCodeAndDateBetween`).
-   **Entity Relationships**: Models and manages many-to-one (`Employee` to `Department`) and many-to-many (`Employee` to `Skill`) relationships.
-   **Criteria API**: Implements a `ProductService` that uses the JPA Criteria API for building dynamic, type-safe queries for filtering products based on multiple criteria.
-   **Test Runner**: A `CommandLineRunner` (`TestRunner.java`) executes all the test cases on application startup to demonstrate the implemented features.

#### `LibraryManagement`

A simple, non-web Spring application that illustrates core Spring concepts.

**Features:**
-   **Inversion of Control (IoC)**: The Spring container manages the lifecycle of beans.
-   **Dependency Injection**: Demonstrates both **Constructor Injection** and **Setter Injection** in `BookService`.
-   **Aspect-Oriented Programming (AOP)**: A `LoggingAspect` is used to log method calls in the service layer before and after their execution, separating logging from business logic.

#### `springboot-demo`

A simple RESTful web service built with Spring Boot.

**Features:**
-   **REST API**: Exposes CRUD endpoints (`GET`, `POST`, `PUT`, `DELETE`) for managing `Book` entities.
-   **Spring Data JPA**: Uses `JpaRepository` for data persistence.
-   **In-Memory Database**: Configured to use an H2 in-memory database, which is ideal for development and testing.
-   **H2 Console**: The H2 database console is enabled for easy database inspection during development.

## How to Run the Projects

### Week 1 Projects (Core Java)
These are standard Java projects.
1.  Navigate to the specific project directory (e.g., `week 1/Week 1- Design Patterns and Principles/AdapterPatternExample/`).
2.  Compile all `.java` files: `javac *.java`
3.  Run the main class: `java Main`

### Week 3 Projects (Maven & Spring Boot)
These projects require Java (17+) and Apache Maven.

#### `orm-learn`
1.  **Database Setup**:
    -   Ensure you have a MySQL server running.
    -   Create a database named `ormlearn`. Spring Boot will create the tables based on the entity definitions.
    -   Update the database URL, username, and password in `src/main/resources/application.properties`.
2.  **Run the Application**:
    -   Navigate to the `Week 3/orm-learn/` directory.
    -   Run the application using the Maven wrapper: `./mvnw spring-boot:run` (on Linux/macOS) or `mvnw.cmd spring-boot:run` (on Windows).
    -   The `TestRunner` will execute on startup and print the results of the various data access tests to the console.

#### `springboot-demo`
1.  **Run the Application**:
    -   Navigate to the `Week 3/springboot-demo/springboot-demo/` directory.
    -   Run the application: `./mvnw spring-boot:run` or `mvnw.cmd spring-boot:run`.
    -   The server will start on `http://localhost:8080`.
    -   You can access the H2 console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:librarydb`).
    -   Use a tool like Postman or the provided `test-books.http` file to interact with the API endpoints.

#### `LibraryManagement`
1.  **Run the Application**:
    -   Navigate to the `Week 3/LibraryManagement/LibraryManagement/` directory.
    -   Run the application using the Maven exec plugin: `mvn clean compile exec:java`.
