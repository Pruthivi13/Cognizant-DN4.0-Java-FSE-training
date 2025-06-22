# Cognizant DN4.0 Java FSE Training


This repository contains a collection of Java projects and exercises completed as part of the Cognizant DN4.0 Java Full Stack Engineer (FSE) training program. The exercises cover fundamental concepts in Algorithms, Data Structures, and Design Patterns.

## Content Overview

The repository is structured by weekly topics. Currently, it includes solutions and examples for "Week 1", focusing on two key areas:

1.  **Algorithms and Data Structures**
2.  **Design Patterns and Principles**

### Algorithms and Data Structures

This section provides practical implementations of common data structures and algorithms to solve specific problems.

| Project                      | Description                                                                                                                               | Key Concepts                                              |
| ---------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------- |
| **Inventory Management**     | A system to add, update, and delete products in an inventory.                                                                             | `HashMap` for efficient O(1) average time complexity access. |
| **E-commerce Search**        | Implements and compares search functionalities for products in an e-commerce platform.                                                    | Linear Search vs. Binary Search.                          |
| **Order Sorting System**     | Sorts a list of customer orders based on their total price, comparing the performance and implementation of different sorting algorithms. | Bubble Sort and Quick Sort.                               |
| **Employee Management**      | A system for managing employee records, including adding, searching, traversing, and deleting employees.                                  | Array manipulation for data management.                   |
| **Task Management System**   | A system to manage a list of tasks (add, search, traverse, delete) using a dynamic data structure.                                        | Singly Linked List.                                       |
| **Library Management**       | A tool to search for books in a library's collection by title.                                                                            | Linear Search and Binary Search.                          |
| **Financial Forecasting**    | A tool to predict future value based on present value, growth rate, and time, using a recursive approach.                                 | Recursion, memoization (optimized version).               |

### Design Patterns and Principles

This section contains examples of various creational, structural, and behavioral design patterns, along with a practical demonstration of Dependency Injection.

| Pattern                     | Example                                                                                                                  | Purpose                                                                               |
| --------------------------- | ------------------------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------- |
| **Singleton Pattern**       | A `Logger` class that ensures only one instance of the logger is created throughout the application.                     | Restrict the instantiation of a class to a single object.                             |
| **Factory Method Pattern**  | Document factories (`Word`, `PDF`, `Excel`) that create specific document types without exposing creation logic.         | Define an interface for creating an object, but let subclasses decide which class to instantiate. |
| **Builder Pattern**         | A `Computer` builder that constructs a complex computer object step-by-step with various optional configurations.        | Separate the construction of a complex object from its representation.              |
| **Adapter Pattern**         | Adapters for `PayPal` and `Stripe` gateways to make their incompatible interfaces work with a common `PaymentProcessor`. | Allow objects with incompatible interfaces to collaborate.                            |
| **Decorator Pattern**       | `SMSNotifierDecorator` and `SlackNotifierDecorator` that dynamically add notification channels to a base `EmailNotifier`.  | Add new functionality to an object dynamically without altering its structure.          |
| **Proxy Pattern**           | A `ProxyImage` that controls access to a `RealImage` object, providing lazy loading functionality.                      | Provide a surrogate or placeholder for another object to control access to it.        |
| **Strategy Pattern**        | A `PaymentContext` that switches between different payment strategies (`CreditCardPayment`, `PayPalPayment`) at runtime. | Define a family of algorithms and make them interchangeable.                          |
| **Observer Pattern**        | A `StockMarket` that notifies registered observers (`MobileApp`, `WebApp`) whenever a stock price changes.                | Define a one-to-many dependency so that when one object changes state, all its dependents are notified. |
| **Command Pattern**         | A `RemoteControl` that uses `Command` objects (`LightOnCommand`, `LightOffCommand`) to execute actions on a `Light`.     | Encapsulate a request as an object, thereby letting you parameterize clients with different requests. |
| **MVC Pattern**             | A simple application separating student data (Model), display logic (View), and user input handling (Controller).        | Separate application logic into three interconnected components.                      |
| **Dependency Injection**    | A `CustomerService` that receives its `CustomerRepository` dependency via its constructor, promoting loose coupling.     | Invert the flow of control for managing dependencies.                                 |

## How to Run the Examples

Each example is self-contained within its own directory. To run an example, you can compile and execute the `Main.java` file.

### For Projects without Packages

1.  Navigate to the specific example's directory.
    ```bash
    cd "week 1/Week 1- Design Patterns and Principles/BuilderPatternExample/"
    ```
2.  Compile all Java files.
    ```bash
    javac *.java
    ```
3.  Run the main class.
    ```bash
    java Main
    ```

### For Projects with Packages (in a `src` directory)

1.  Navigate to the example's root directory (the a folder containing `src`).
    ```bash
    cd "week 1/Week 1- Design Patterns and Principles/CommandPatternExample/"
    ```
2.  Compile the source files from the root directory.
    ```bash
    javac src/command/*.java
    ```
3.  Run the main class from the root directory, specifying the fully qualified name.
    ```bash
    java command.Main
