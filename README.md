# Cognizant DN4.0 Java FSE Training

This repository contains a collection of projects and exercises completed as part of the Cognizant DN4.0 Java Full Stack Engineer (FSE) training program. The content is organized by weekly topics and covers fundamental concepts in Java (Algorithms, Data Structures, Design Patterns) and PL/SQL.

## Week 1: Java Fundamentals

This section focuses on core Java programming, divided into practical implementations of algorithms and data structures, and examples of common software design patterns.

### Algorithms and Data Structures

These projects solve common problems using fundamental algorithms and data structures.

| Project | Description | Key Concepts |
|---|---|---|
| **Inventory Management** | A system to add, update, and delete products from an inventory. | `HashMap` for efficient data retrieval. |
| **E-commerce Search** | Implements and compares linear and binary search for finding products. | Linear Search, Binary Search. |
| **Order Sorting System** | Sorts customer orders by price using different algorithms. | Bubble Sort, Quick Sort. |
| **Employee Management** | A system for basic employee record management. | Array-based data structures. |
| **Task Management System** | Manages a list of tasks using a dynamic data structure. | Singly Linked List. |
| **Library Management** | A tool for searching for books by title in a library catalog. | Linear Search, Binary Search. |
| **Financial Forecasting** | Predicts future value using a recursive approach. | Recursion, Memoization. |

### Design Patterns and Principles

This section provides practical examples for various creational, structural, and behavioral design patterns.

| Pattern | Example | Purpose |
|---|---|---|
| **Singleton** | A `Logger` class that ensures only one instance is ever created. | Restrict the instantiation of a class to a single object. |
| **Factory Method** | Document factories (`Word`, `PDF`, `Excel`) to create objects without specifying the exact class. | Define an interface for creating an object, but let subclasses decide which class to instantiate. |
| **Builder** | A `Computer` builder for constructing a complex object step-by-step. | Separate the construction of a complex object from its representation. |
| **Adapter** | Adapters for `PayPal` and `Stripe` to work with a common `PaymentProcessor` interface. | Allow objects with incompatible interfaces to collaborate. |
| **Decorator** | Dynamically adding `SMS` and `Slack` notifications to a base `EmailNotifier`. | Add new functionality to an object dynamically without altering its structure. |
| **Proxy** | A `ProxyImage` that provides lazy loading for a `RealImage` object. | Provide a surrogate or placeholder for another object to control access to it. |
| **Strategy** | A `PaymentContext` that switches between `CreditCard` and `PayPal` payment strategies. | Define a family of algorithms and make them interchangeable at runtime. |
| **Observer** | A `StockMarket` that notifies registered `MobileApp` and `WebApp` observers of price changes. | Define a one-to-many dependency where objects are notified of state changes. |
| **Command** | A `RemoteControl` that uses `Command` objects to turn a `Light` on and off. | Encapsulate a request as an object, parameterizing clients with different requests. |
| **MVC** | A simple application separating student data (Model), display (View), and logic (Controller). | Separate application logic into three interconnected components. |
| **Dependency Injection** | A `CustomerService` that receives its `CustomerRepository` dependency via its constructor. | Achieve loose coupling by inverting the control of dependency management. |

## Week 2: PL/SQL Exercises

This section contains a series of PL/SQL scripts demonstrating core database programming concepts on an Oracle database. The exercises cover creating procedures, functions, triggers, and packages to perform various data manipulation and business logic tasks.

| Exercise | Topic Covered | Example Task |
|---|---|---|
| **Exercise 1** | **PL/SQL Blocks & Loops** | Iterating through customers to apply a discount to their loan interest rates. |
| **Exercise 2** | **Stored Procedures & Error Handling** | Creating a procedure for safe fund transfers with exception handling for insufficient funds. |
| **Exercise 3** | **Advanced Procedures** | Building a procedure to apply monthly interest to all savings accounts. |
| **Exercise 4** | **Functions** | Creating a function to calculate a customer's age based on their date of birth. |
| **Exercise 5** | **Triggers** | Creating a trigger to automatically log transaction details into an audit table. |
| **Exercise 6** | **Cursors** | Using a cursor to iterate through all loans and update interest rates based on the loan amount. |
| **Exercise 7** | **Packages** | Bundling related procedures and functions into a `CustomerManagement` package. |

## Week 2: JUnit and Mockito Exercises

This section contains projects and examples related to Test-Driven Development (TDD) using JUnit 4, JUnit 5, and Mockito frameworks. The content is organized into several Maven projects demonstrating basic to advanced testing techniques and mocking capabilities.

### Projects Overview

| Project | Description |
|---|---|
| **junit-example** | Basic JUnit 4 and JUnit 5 test examples demonstrating fundamental testing concepts. |
| **junit-advance** | Advanced JUnit 5 test examples with code quality tools like Checkstyle and JaCoCo for coverage. |
| **mockito-demo** | Mockito test examples integrated with JUnit 5, showcasing mocking and verification techniques. |
| **Logging using SLF4J** | Examples demonstrating logging practices using the SLF4J framework. |

### How to Run the Tests

Each project is a Maven project. To run the tests, navigate to the project directory and use the following commands:

```bash
# Navigate to the project directory, e.g. junit-example
cd "Week 2- TDD using JUnit5 and Mockito/junit-example"

# Run tests using Maven
mvn clean test
```

This will compile the code and run all tests, showing the results in the console.

---

## How to Run the Examples

### Java Examples

Each Java project is self-contained. To run an example, navigate to its directory and use the `javac` and `java` commands.

**1. For projects without packages:**
```bash
# Navigate to the example directory
cd "week 1/Week 1- Design Patterns and Principles/BuilderPatternExample/"

# Compile all .java files
javac *.java

# Run the Main class
java Main
```

**2. For projects with packages (inside a `src` directory):**
```bash
# Navigate to the root directory containing src
cd "week 1/Week 1- Design Patterns and Principles/CommandPatternExample/"

# Compile the source files from the root
javac src/command/*.java

# Run the Main class from the root, using the fully qualified name
java command.Main
```

### PL/SQL Scripts

The PL/SQL scripts are intended to be run in a SQL client connected to an Oracle database (e.g., SQL*Plus, Oracle SQL Developer).

1.  Connect to your Oracle database schema.
2.  Ensure that the necessary tables (e.g., `Customers`, `Accounts`, `Loans`) exist in your schema with the appropriate columns, as the scripts depend on them.
3.  Open a script file and execute its content in your SQL client.
