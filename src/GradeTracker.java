import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeTracker {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(String name) {
        if (findStudent(name) != null) {
            System.out.println("Student \"" + name + "\" already exists.");
            return;
        }
        students.add(new Student(name));
        System.out.println("Student \"" + name + "\" added.");
    }

    public Student findStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void addGradeToStudent(String name, String subject, int score) {
        Student student = findStudent(name);
        if (student == null) {
            System.out.println("Student \"" + name + "\" not found.");
            return;
        }
        try {
            student.addGrade(subject, score);
            System.out.println("Grade added for " + name + ".");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printStudentReport(String name) {
        Student student = findStudent(name);
        if (student == null) {
            System.out.println("Student \"" + name + "\" not found.");
            return;
        }
        System.out.println("\n--- Report for " + student.getName() + " ---");
        if (!student.hasGrades()) {
            System.out.println("No grades recorded yet.");
            return;
        }
        for (Grade g : student.getGrades()) {
            System.out.println("  " + g);
        }
        System.out.printf("  Average: %.2f%n", student.getAverage());
        System.out.println("  Highest: " + student.getHighest());
        System.out.println("  Lowest:  " + student.getLowest());
    }

    public void printSummaryReport() {
        System.out.println("\n=== Summary Report — All Students ===");
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        for (Student s : students) {
            if (s.hasGrades()) {
                System.out.printf("%-15s | Avg: %6.2f | Highest: %-15s | Lowest: %-15s%n",
                        s.getName(), s.getAverage(), s.getHighest(), s.getLowest());
            } else {
                System.out.printf("%-15s | No grades recorded%n", s.getName());
            }
        }
    }
}
