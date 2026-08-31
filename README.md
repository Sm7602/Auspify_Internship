# 🎓 Student Management System

> **A clean, menu-driven Core Java application for managing student
> records using OOP, collections, validation, and CRUD operations.**

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Type](https://img.shields.io/badge/Project-Core%20Java-blue)
![Architecture](https://img.shields.io/badge/Architecture-Layered%20Responsibilities-success)
![Status](https://img.shields.io/badge/Status-Learning%20Project-informational)

------------------------------------------------------------------------

## 📌 Overview

The **Student Management System** is a console-based Java application
created to demonstrate practical **Core Java and Object-Oriented
Programming** concepts.

The application provides a simple menu through which users can:

-   Add students
-   View all students
-   Search students
-   Update student information
-   Delete students
-   Validate user input

The project separates the **student model, business logic, validation,
and user interaction** into different classes, making the code easier to
understand and maintain.

> **Important:** Student records are currently stored in memory using
> `ArrayList`. Data is lost when the application terminates.

------------------------------------------------------------------------

## ✨ Key Features

### 👨‍🎓 Student Management

-   Add a new student
-   View all registered students
-   Search by Student ID
-   Update student information
-   Delete student records

### ✅ Input Validation

-   Validate student name
-   Validate age
-   Validate grade
-   Validate Student ID
-   Validate 10-digit contact number

### 🛡️ Data Rules

-   Duplicate Student IDs are rejected
-   Grades are normalized to uppercase
-   Contact numbers must contain exactly 10 digits
-   Student IDs are treated as text rather than numeric values

------------------------------------------------------------------------

## 🧑‍🎓 Student Model

The application uses the following student attributes:

  Attribute     Type       Example          Purpose
  ------------- ---------- ---------------- ---------------------------
  `studentId`   `String`   `STU101`         Unique student identifier
  `name`        `String`   `Souvik Maity`   Student name
  `age`         `byte`     `21`             Student age
  `grade`       `char`     `A`              Academic grade
  `contact`     `String`   `9876543210`     Contact number

### Why is contact a `String`?

A phone number should not be stored as an integer because it is an
identifier, not a value used for arithmetic. Using `String` also
prevents issues with leading zeros and allows future formats such as
country codes.

------------------------------------------------------------------------

# 🏗️ Project Architecture

``` text
┌─────────────────────────────────────────┐
│       StudentInformationSystem          │
│          Console / User Input            │
└───────────────────┬─────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────┐
│             ValidationUtils             │
│           Input Validation               │
└───────────────────┬─────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────┐
│             StudentManager              │
│           Business / CRUD Logic          │
└───────────────────┬─────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────┐
│                Student                  │
│             Domain Model                 │
└─────────────────────────────────────────┘
                    │
                    ▼
┌─────────────────────────────────────────┐
│              ArrayList                  │
│          In-Memory Data Storage          │
└─────────────────────────────────────────┘
```

------------------------------------------------------------------------

# 📁 Project Structure

``` text
Student-Information-System/
│
├── src/
│   └── week_1_task_project/
│       ├── Student.java
│       ├── StudentManager.java
│       ├── ValidationUtils.java
│       └── StudentInformationSystem.java
│
├── README.md
├── sample-data.txt
└── .gitignore
```

------------------------------------------------------------------------

# 🧩 Class Responsibilities

## `Student.java`

The domain/model class representing a student.

Responsibilities:

-   Store student information
-   Encapsulate fields using `private`
-   Initialize data through a constructor
-   Provide getters/setters
-   Provide readable object output through `toString()`

------------------------------------------------------------------------

## `StudentManager.java`

The business logic layer.

Responsibilities:

-   Add students
-   Retrieve all students
-   Find students by ID
-   Update student records
-   Delete student records
-   Maintain the student collection
-   Handle duplicate Student ID checks

------------------------------------------------------------------------

## `ValidationUtils.java`

The validation utility class.

Responsibilities:

``` text
Name validation
       +
Age validation
       +
Grade validation
       +
Student ID validation
       +
Contact validation
```

Keeping validation separate prevents the main menu class from becoming
unnecessarily large.

------------------------------------------------------------------------

## `StudentInformationSystem.java`

The application entry point.

Responsibilities:

-   Start the application
-   Display the menu
-   Read user input
-   Call validation methods
-   Call StudentManager operations
-   Display results to the user

------------------------------------------------------------------------

# 🖥️ Application Menu

``` text
========================================
       STUDENT INFORMATION SYSTEM
========================================

1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit

Enter your choice:
```

------------------------------------------------------------------------

# 🔄 Application Workflow

### Add Student

``` text
User Input
    ↓
Validate Data
    ↓
Check Duplicate Student ID
    ↓
Create Student Object
    ↓
Add to ArrayList
    ↓
Success Message
```

### Search Student

``` text
Student ID
    ↓
StudentManager
    ↓
Search ArrayList
    ↓
Student Found?
   /      \
 Yes       No
 ↓          ↓
Display    Error
```

------------------------------------------------------------------------

# 🛠️ Technologies

-   **Java 17+**
-   Core Java
-   Object-Oriented Programming
-   Java Collections Framework
-   `ArrayList`
-   `Scanner`
-   Regular Expressions
-   Console-based application

------------------------------------------------------------------------

# ▶️ Getting Started

## Prerequisites

Install Java 17 or a later compatible JDK.

Verify installation:

``` bash
java -version
javac -version
```

------------------------------------------------------------------------

## Running in Eclipse

1.  Open Eclipse.
2.  Import or create the Java project.
3.  Place the source files inside the correct package.
4.  Verify the package declaration matches the project structure.
5.  Run:

``` text
StudentInformationSystem.java
```

6.  Follow the console menu.

------------------------------------------------------------------------

## Running from Command Line

If the source files use the package:

``` java
package week_1_task_project;
```

Compile:

``` bash
javac -d . Student.java StudentManager.java ValidationUtils.java StudentInformationSystem.java
```

Run:

``` bash
java week_1_task_project.StudentInformationSystem
```

------------------------------------------------------------------------

# 🧪 Sample Data

Sample records are provided in:

``` text
sample-data.txt
```

The application currently does **not automatically import this file**.
Use the records as manual test input through the **Add Student** menu.

Example:

``` text
STU101 | Souvik Maity | 21 | A | 9876543210
STU102 | Rahul Kumar  | 22 | B | 9876543211
STU103 | Priya Sharma | 20 | A | 9876543212
```

------------------------------------------------------------------------

# 🧪 Test Plan

  ID      Scenario            Input                 Expected Result
  ------- ------------------- --------------------- ---------------------------
  TC-01   Add valid student   Valid details         Student added
  TC-02   View students       Option `2`            Student list displayed
  TC-03   Search existing     `STU101`              Correct student displayed
  TC-04   Search missing      `STU999`              Student not found
  TC-05   Update existing     `STU101` + new data   Student updated
  TC-06   Update missing      `STU999`              Student not found
  TC-07   Delete existing     `STU101`              Student deleted
  TC-08   Delete missing      `STU999`              Student not found
  TC-09   Duplicate ID        Existing ID           Duplicate rejected
  TC-10   Invalid age         `150`                 Validation error
  TC-11   Invalid grade       `X`                   Validation error
  TC-12   Invalid contact     `12345`               Validation error
  TC-13   Empty name          Empty input           Validation error
  TC-14   Invalid menu        `9`                   Invalid choice
  TC-15   Exit                `6`                   Application closes

------------------------------------------------------------------------

# 📋 Validation Rules

  Field        Rule
  ------------ ---------------------------
  Name         Cannot be null or empty
  Age          5--100
  Grade        A, B, C, D, F
  Student ID   Cannot be null or empty
  Contact      Exactly 10 numeric digits

------------------------------------------------------------------------

# 📸 Example Console Session

``` text
===== STUDENT INFORMATION SYSTEM =====
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Exit

Enter your choice: 1

Enter Student ID: STU101
Enter Name: Souvik Maity
Enter Age: 21
Enter Grade: A
Enter Contact: 9876543210

Student added successfully.
```

Search:

``` text
Enter your choice: 3

Enter Student ID: STU101

Student found:
Student{
name='Souvik Maity',
age=21,
grade=A,
studentId='STU101',
contact='9876543210'
}
```

------------------------------------------------------------------------

# ⚠️ Current Limitations

This project is intentionally a **Core Java learning project**, not a
production application.

Current limitations:

-   Data is stored only in memory
-   Data disappears after application shutdown
-   No database
-   No REST API
-   No authentication/authorization
-   No GUI
-   No automated JUnit test suite
-   Console input handling can be improved with custom exception
    handling

These are natural next steps rather than features that should be falsely
claimed as implemented.

------------------------------------------------------------------------

# 🚀 Future Enhancements

## Phase 1 --- Improve Core Java

-   Custom exceptions
-   Better input handling
-   Sorting
-   Search by name
-   File persistence
-   Stream API
-   Java records where appropriate

## Phase 2 --- Testing

-   JUnit 5
-   Mockito where appropriate
-   Unit tests for `StudentManager`
-   Validation tests
-   Edge-case tests

## Phase 3 --- Backend Version

Convert the project into a Spring Boot backend:

``` text
Spring Boot
    ↓
REST Controller
    ↓
Service Layer
    ↓
Repository Layer
    ↓
MySQL
```

Potential additions:

-   Spring Data JPA
-   DTOs
-   Global exception handling
-   Bean Validation
-   Swagger/OpenAPI
-   Pagination and sorting

## Phase 4 --- Security

-   Spring Security
-   JWT authentication
-   Role-based authorization
-   Password encryption
-   Secure API endpoints

------------------------------------------------------------------------

# 🐛 Important Code Quality Note

Before publishing the project, verify String comparisons in
`StudentManager`.

Avoid:

``` java
student.getStudentId() == id
```

Use:

``` java
student.getStudentId().equals(id)
```

or:

``` java
student.getStudentId().equalsIgnoreCase(id)
```

### Why?

`==` compares object references for Strings, while `equals()` compares
their actual contents.

This matters because Student ID lookup can affect:

-   Search
-   Update
-   Delete
-   Duplicate ID detection

This should be fixed before treating the application as fully reliable.

------------------------------------------------------------------------

# 📊 Project Evaluation

  Area                         Rating
  ---------------------- ------------
  Java Fundamentals        ⭐⭐⭐⭐⭐
  OOP                       ⭐⭐⭐⭐☆
  Collections               ⭐⭐⭐⭐☆
  Validation                ⭐⭐⭐⭐☆
  Code Organization         ⭐⭐⭐⭐☆
  Persistence                  ⭐☆☆☆☆
  Testing                      ⭐☆☆☆☆
  Production Readiness        ⭐⭐☆☆☆

### Overall: **7/10 --- Core Java Learning Project**

The project successfully demonstrates Java fundamentals and basic OOP
architecture.

For a resume-level backend project, it needs persistence, automated
tests, a database, REST APIs, and security.

------------------------------------------------------------------------

# 🎯 Learning Outcomes

After completing this project, you should understand:

-   Java variables and data types
-   Classes and objects
-   Constructors
-   Encapsulation
-   Getters and setters
-   Methods
-   Conditional statements
-   Loops
-   Switch statements
-   Collections
-   `ArrayList`
-   Input validation
-   CRUD operations
-   Separation of responsibilities

------------------------------------------------------------------------

# 👨‍💻 Author

**Souvik Maity**

Java Backend Developer --- Learning Project

------------------------------------------------------------------------

## 📄 License

This project is created for educational and learning purposes.


