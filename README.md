# 🎯 Number Master — Multi-Level Number Guessing Game

A console-based **Number Guessing Game built with Java** that challenges players across multiple difficulty levels.

The game combines random number generation, input validation, difficulty-based scoring, hints, player statistics, and a persistent leaderboard to create a complete command-line gaming experience.

---

## 📌 Project Overview

**Number Master** is a Java console application where the player attempts to guess a randomly generated number within a limited number of attempts.

The game provides four difficulty levels:

| Level     | Number Range | Attempts | Base Score | Multiplier |
| --------- | -----------: | -------: | ---------: | ---------: |
| 🟢 Easy   |         1–10 |        5 |      1,000 |       1.0x |
| 🟡 Medium |         1–50 |        7 |      1,500 |       1.5x |
| 🔴 Hard   |        1–100 |        8 |      2,000 |       2.0x |
| 🔥 Expert |        1–500 |       10 |      3,000 |       3.0x |

Players receive **High/Low feedback**, can use up to **2 hints**, earn scores based on performance, and compete for a position on the leaderboard.

---

## ✨ Features

### 🎮 Core Gameplay

* Random secret number generation
* Four difficulty levels
* Configurable number ranges
* Limited attempts based on difficulty
* High/Low guessing feedback
* Win and Game Over screens
* Replay functionality

### 💡 Hint System

Players can use up to **2 hints per round**.

Available hints include:

* Whether the secret number is **Even or Odd**
* Whether the number is in the **Lower or Upper half** of the range

Using hints reduces the final score.

### 🏆 Scoring System

The score is calculated using:

```text
Base Score
    - Attempt Penalties
    - Hint Penalties
    ↓
Minimum score = 0
    ↓
Difficulty Multiplier
    ↓
Final Score
```

Current scoring rules:

```text
Attempt Penalty = 100 points
Hint Penalty    = 150 points
```

The first attempt does not receive an attempt penalty.

### 👤 Player Statistics

The application tracks:

* Player name
* Games played
* Games won
* Games lost
* Win percentage
* Total score
* Best score
* Average score

### 🏅 Persistent Leaderboard

The top **10 scores** are maintained and stored locally.

Leaderboard entries contain:

```text
Player Name | Level | Score
```

Example:

```text
souvik|Easy|650
```

The leaderboard is:

* Sorted by highest score
* Limited to the top 10 entries
* Persisted between application runs
* Loaded automatically when the application starts

### 🛡️ Input Validation

The application validates:

* Empty input
* Invalid numeric input
* Out-of-range guesses
* Invalid player names
* Invalid Yes/No responses
* Invalid game menu selections

Player names must:

* Contain at least 2 characters
* Contain no more than 20 characters
* Use letters, numbers, spaces, `_`, or `-`

---

## 🏗️ Project Architecture

The project follows a simple **object-oriented, responsibility-based architecture**.

```text
                    ┌─────────────────────┐
                    │       Main.java     │
                    │  Application Entry  │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │      Game.java      │
                    │   Game Controller   │
                    └──────┬───────┬──────┘
                           │       │
              ┌────────────┘       └─────────────┐
              ▼                                  ▼
     ┌─────────────────┐                ┌──────────────────┐
     │    Level.java   │                │  GameUtils.java  │
     │ Difficulty Data │                │ Input Validation │
     └─────────────────┘                └──────────────────┘
              │
              ▼
     ┌─────────────────┐
     │    Player.java  │
     │ Player Statistics│
     └────────┬────────┘
              │
              ▼
     ┌──────────────────────┐
     │   ScoreManager.java  │
     │ Score + Leaderboard  │
     └──────────┬───────────┘
                │
                ▼
       ┌─────────────────┐
       │ leaderboard.txt │
       │ Persistent Data │
       └─────────────────┘
```

---

## 📁 Project Structure

```text
Number-Guessing-Game-main/
│
├── Main.java
├── Game.java
├── Level.java
├── Player.java
├── ScoreManager.java
├── GameUtils.java
│
└── leaderboard.txt
```

### `Main.java`

Application entry point.

Responsibilities:

* Start the application
* Create the `Game` object
* Create the player
* Display the main menu
* Handle menu selection
* Exit the application

---

### `Game.java`

Contains the primary game logic.

Responsibilities:

* Start game rounds
* Select difficulty
* Generate random numbers
* Process guesses
* Provide High/Low feedback
* Manage hints
* Calculate and save scores
* Handle wins and losses
* Display instructions
* Display leaderboard

---

### `Level.java`

An enum representing the four game difficulty levels.

Each level contains:

* Display name
* Minimum number
* Maximum number
* Maximum attempts
* Base score
* Score multiplier

Using an enum makes the difficulty configuration centralized and type-safe.

---

### `Player.java`

Represents the current player.

Maintains:

```text
Name
Total Score
Games Played
Games Won
Games Lost
Best Score
```

It also calculates:

* Win percentage
* Average score

The class uses validation and encapsulation to protect player data.

---

### `ScoreManager.java`

Responsible for scoring and leaderboard management.

Responsibilities:

* Calculate final scores
* Save scores
* Load scores
* Sort scores
* Keep the top 10 entries
* Display leaderboard
* Handle file I/O

The leaderboard uses Java's `List`, `Comparator`, `BufferedReader`, `BufferedWriter`, and `Files` APIs.

---

### `GameUtils.java`

A utility class containing reusable input-validation methods.

Includes:

```java
getValidInteger()
getValidPlayerName()
getYesNo()
getNonEmptyString()
pressEnterToContinue()
```

The class has a private constructor, preventing unnecessary object creation.

---

### `leaderboard.txt`

Stores leaderboard data locally.

Format:

```text
playerName|level|score
```

Example:

```text
souvik|Easy|650
```

---

## 🎯 Game Flow

```text
Application Starts
       │
       ▼
Enter Player Name
       │
       ▼
Main Menu
       │
       ├── Start Game
       │       │
       │       ▼
       │   Select Level
       │       │
       │       ▼
       │   Generate Secret Number
       │       │
       │       ▼
       │   Enter Guess
       │       │
       │       ├── Correct ──► Calculate Score
       │       │                    │
       │       │                    ▼
       │       │              Save Leaderboard
       │       │
       │       └── Incorrect
       │              │
       │              ▼
       │          High / Low
       │              │
       │              ▼
       │          Optional Hint
       │              │
       │              ▼
       │        Attempts Remaining?
       │              │
       │         Yes ─┴─ No
       │                    │
       │                    ▼
       │                 Game Over
       │
       ├── How to Play
       │
       ├── Leaderboard
       │
       └── Exit
```

---

## 🧮 Scoring Formula

The project uses the following logic:

```text
Wrong Attempts = Attempts Used - 1

Score =
Base Score
- (Wrong Attempts × 100)
- (Hints Used × 150)

Score = max(Score, 0)

Final Score =
Score × Difficulty Multiplier
```

### Example

Suppose a player completes an Easy round in:

```text
Attempts Used = 3
Hints Used    = 1
Base Score    = 1000
Multiplier    = 1.0
```

Calculation:

```text
Wrong Attempts = 3 - 1
               = 2

Attempt Penalty = 2 × 100
                = 200

Hint Penalty = 1 × 150
             = 150

Score = 1000 - 200 - 150
      = 650

Final Score = 650 × 1.0
            = 650
```

Therefore:

```text
Final Score = 650
```

---

## 🛠️ Technologies Used

| Technology          | Purpose                       |
| ------------------- | ----------------------------- |
| Java                | Core programming language     |
| Java OOP            | Application design            |
| Java Enum           | Difficulty configuration      |
| Java Record         | Immutable leaderboard entries |
| `java.util.Scanner` | User input                    |
| `java.util.Random`  | Secret number generation      |
| Java Collections    | Leaderboard management        |
| Java NIO            | File operations               |
| `Comparator`        | Leaderboard sorting           |
| Text File Storage   | Persistent leaderboard        |

---

## 💻 Requirements

Before running the application, make sure you have:

* **Java 17 or later**
* JDK installed and configured
* Terminal / Command Prompt
* A Java IDE such as IntelliJ IDEA, Eclipse, or VS Code

Java 17+ is recommended because the project uses modern Java features including:

* Records
* Enhanced switch expressions
* Text blocks
* Pattern matching for `instanceof`

---

## 🚀 How to Run

### Option 1 — IntelliJ IDEA

1. Extract the ZIP file.
2. Open the project in IntelliJ IDEA.
3. Make sure the source files are located in the correct package:

```text
week_2_task_HOP_game
```

4. Open `Main.java`.
5. Run:

```text
Main.main()
```

---

### Option 2 — Eclipse

1. Extract the project.
2. Create/open a Java project.
3. Add the Java source files.
4. Ensure the package declaration matches:

```java
package week_2_task_HOP_game;
```

5. Run `Main.java` as a Java Application.

---

### Option 3 — Command Line

From the directory containing the Java files, compile:

```bash
javac -d . *.java
```

Then run:

```bash
java week_2_task_HOP_game.Main
```

---

## 🖥️ Application Menu

When the application starts, the player sees:

```text
╔══════════════════════════════════════════╗
║          🎯 NUMBER MASTER 🎯             ║
║       MULTI-LEVEL GUESSING GAME          ║
╚══════════════════════════════════════════╝

Welcome to Number Master!
Test your guessing skills across multiple levels.

MAIN MENU

1. 🎮 Start Game
2. 📖 How to Play
3. 🏆 Leaderboard
4. 🚪 Exit
```

---

## 🎮 Difficulty Levels

### 🟢 Easy

```text
Range     : 1 - 10
Attempts  : 5
Base Score: 1000
Multiplier: 1.0x
```

Recommended for beginners.

### 🟡 Medium

```text
Range     : 1 - 50
Attempts  : 7
Base Score: 1500
Multiplier: 1.5x
```

Requires better guessing strategy.

### 🔴 Hard

```text
Range     : 1 - 100
Attempts  : 8
Base Score: 2000
Multiplier: 2.0x
```

A more challenging experience.

### 🔥 Expert

```text
Range     : 1 - 500
Attempts  : 10
Base Score: 3000
Multiplier: 3.0x
```

Designed for players who want the highest challenge and scoring potential.

---

## 💡 Hint System

Each round allows a maximum of **2 hints**.

### Hint 1

Provides the parity of the secret number:

```text
The number is EVEN.
```

or:

```text
The number is ODD.
```

### Hint 2

Provides the approximate position:

```text
The number is in the LOWER half of the range.
```

or:

```text
The number is in the UPPER half of the range.
```

Each hint costs:

```text
150 points
```

Therefore, using hints strategically is important.

---

## 🏆 Leaderboard

The application maintains the top 10 scores.

Leaderboard sorting rules:

1. Highest score first
2. Player name alphabetically when scores are equal

Example:

```text
================================================================
Rank   Player               Level        Score
----------------------------------------------------------------
1      souvik               Expert       8100
2      Rahul                Hard         3400
3      Amit                 Medium       1950
================================================================
```

Leaderboard data is persisted in:

```text
leaderboard.txt
```

The application automatically loads existing scores when started.

---

## 🧠 Object-Oriented Programming Concepts Used

This project demonstrates several important Java OOP concepts.

### Encapsulation

Player fields are private and accessed through methods.

```java
private int totalScore;
private int gamesPlayed;
```

### Abstraction

Game operations are separated into dedicated classes such as:

```text
Game
Player
ScoreManager
GameUtils
```

### Enum

Difficulty levels are represented using:

```java
public enum Level
```

This provides a clean and type-safe representation of game levels.

### Immutability

`ScoreEntry` is implemented as a Java record:

```java
public record ScoreEntry(
    String playerName,
    String level,
    int score
) {}
```

### Utility Class Pattern

`GameUtils` uses a private constructor to prevent instantiation.

### Collections

The leaderboard is managed using:

```java
List<ScoreEntry>
```

### Sorting

Scores are sorted using Java's `Comparator`.

---

## 🔒 Validation & Error Handling

The application prevents invalid user input from breaking the game.

Examples:

```text
❌ Input cannot be empty.
❌ Invalid input! Please enter a number.
❌ Invalid range!
❌ Player name cannot be empty.
❌ Name cannot contain more than 20 characters.
❌ Invalid characters in name.
❌ Please enter Y/Yes or N/No.
```

File operations are also protected using exception handling for `IOException`.

---

## 📊 Current Project Strengths

### Strong Points

* Clean separation of responsibilities
* Good use of OOP
* Multiple difficulty levels
* Reusable validation utilities
* Persistent leaderboard
* Score calculation system
* Player statistics
* Immutable leaderboard entries
* Input validation
* Good console UI
* Easy to extend

---

## ⚠️ Current Limitations

This is a solid console-level Java project, but it is **not yet production-grade software**.

The main limitations are:

1. **No automated unit tests**

   * Core classes such as `ScoreManager`, `Player`, and `GameUtils` should have JUnit tests.

2. **File-based persistence**

   * Leaderboard data is stored in a text file rather than a database.

3. **Single-player session model**

   * Player information exists only during the current application session.

4. **No GUI**

   * The application currently runs entirely through the console.

5. **No Maven/Gradle build configuration**

   * Dependency/build management is currently manual.

6. **No logging framework**

   * Production applications should use a logging framework rather than relying primarily on `System.out.println()`.

7. **Limited leaderboard data**

   * The leaderboard stores player, level, and score but not date/time, attempts, or hints.

These are not failures for a beginner/intermediate Java project, but they are the areas that should be improved if the goal is to present it as a professional portfolio project.

---

## 🔮 Future Enhancements

Possible improvements include:

* [ ] Add JUnit 5 unit tests
* [ ] Add Maven or Gradle
* [ ] Add persistent player profiles
* [ ] Replace text-file storage with MySQL
* [ ] Add timestamps to leaderboard entries
* [ ] Add difficulty customization
* [ ] Add multiple players
* [ ] Add daily challenge mode
* [ ] Add achievements
* [ ] Add streak tracking
* [ ] Add sound effects
* [ ] Build a JavaFX GUI
* [ ] Create a Spring Boot REST API version
* [ ] Add a web-based frontend
* [ ] Add authentication for online leaderboards
* [ ] Add Docker support

---

## 🧪 Suggested Testing Strategy

For a stronger professional submission, test the following areas.

### Player Tests

* Valid player creation
* Empty player name
* Score addition
* Negative score rejection
* Win tracking
* Loss tracking
* Best score calculation
* Win percentage
* Average score
* Player equality

### GameUtils Tests

* Valid integer
* Invalid integer
* Integer range validation
* Invalid player name
* Valid player name
* Yes/No input

### ScoreManager Tests

* Score calculation
* Attempt penalties
* Hint penalties
* Difficulty multipliers
* Negative score prevention
* Leaderboard sorting
* Top 10 limitation
* File persistence

---

## 📸 Recommended Screenshots for GitHub

For a professional GitHub repository, add screenshots showing:

1. Main menu
2. Difficulty selection
3. Gameplay
4. Hint system
5. Winning screen
6. Game-over screen
7. Leaderboard
8. Player statistics

Suggested folder:

```text
screenshots/
├── main-menu.png
├── level-selection.png
├── gameplay.png
├── hint.png
├── winning-screen.png
├── game-over.png
└── leaderboard.png
```

---

## 🎓 Learning Outcomes

This project demonstrates practical understanding of:

* Java fundamentals
* Object-Oriented Programming
* Classes and objects
* Encapsulation
* Enums
* Records
* Collections
* Exception handling
* Input validation
* Random number generation
* File I/O
* Comparator and sorting
* Java NIO
* Modular class design
* Basic software architecture

---

## 👨‍💻 Author

**Souvik Maity**

Java Backend Developer — Aspiring

### Skills Demonstrated

```text
Java
OOP
Collections
Exception Handling
File I/O
Data Validation
Clean Code
Problem Solving
```

---

## 📄 License

This project is created for **educational and portfolio purposes**.

You are free to study, modify, and extend the project for learning purposes.

---

## ⭐ Support

If you found this project useful, consider giving the repository a ⭐ on GitHub.

---

## 📌 Project Summary

**Number Master** is more than a basic number guessing program. It demonstrates how a simple game can be structured into multiple focused Java classes with reusable utilities, configurable difficulty levels, scoring logic, player statistics, validation, and persistent leaderboard management.

The project is particularly useful for demonstrating **core Java and OOP skills in a practical application**.

**Current level:** Beginner → Intermediate Java project

**Best next upgrade:** Add **JUnit tests + Maven + database persistence**. Those three changes would make the project substantially stronger for a Java backend portfolio.

