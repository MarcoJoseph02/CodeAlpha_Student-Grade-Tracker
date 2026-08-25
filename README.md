# CodeAlpha_StudentGradeTracker

A console-based Student Grade Tracker built in Java as part of the **CodeAlpha Java Programming Internship**. The application manages students and their grades per subject, calculates performance statistics, and produces summary reports — built with a clean, SOLID-compliant object-oriented design rather than a single monolithic script.

## Features

- Add students
- Record grades for different subjects
- Validate grades using a 0–100 score range
- Calculate each student's average grade
- Find the highest and lowest grade
- Per-student report: all grades, average, highest, and lowest score
- Display a summary of all students
- Simple interactive console menu


## Tech Stack

- **Java 17** (no external dependencies — pure Java, uses `ArrayList` for in-memory storage as required by the task specification)

## Design & Architecture

The project intentionally goes beyond a basic script to demonstrate SOLID principles in a small, readable codebase:

| Principle | How it's applied |
|---|---|
| **Single Responsibility** | `Grade` holds data, `Student` manages one student's grades, `GradeTracker` coordinates students, `GradeTrackerApp` handles only console I/O |
| **Open/Closed** | Score validation is abstracted behind the `GradeValidator` interface (`PercentageGradeValidator` is one implementation) — new validation rules can be added without modifying `Student` |
| **Dependency Inversion** | `GradeTracker` depends on the `StudentRepository` interface, not on `ArrayList` directly — storage can be swapped (e.g. to file or database) without touching business logic |

```
src/main/java/com/codealpha/gradetracker/
├── Grade.java                      # Immutable value object: subject + score
├── Student.java                    # Per-student data + calculations
├── GradeTracker.java               # Coordinates students, injected dependencies
└── GradeTrackerApp.java            # Composition root + console menu
```

## How to Run

**Requirements:** JDK 17 or later.

```bash
# From the project root
cd src/main/java
javac com/codealpha/gradetracker/*.java
java com.codealpha.gradetracker.GradeTrackerApp
```

## Sample Usage

```
===== Student Grade Tracker =====
1. Add student
2. Add grade to student
3. View student report
4. View summary report (all students)
5. Exit
Choose an option: 1
Enter student name: Ahmed
Student "Ahmed" added.
```
## This project was developed to practice:

Java programming fundamentals
Object-Oriented Programming
Collections
Input validation
Data processing
Console-based application development

## Part of CodeAlpha Internship

This project was completed as one of the required tasks for the **CodeAlpha Java Programming Internship**.

## License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.
