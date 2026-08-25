import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {

    private final String name;
    private final List<Grade> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addGrade(String subject, int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        grades.add(new Grade(subject, score));
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public boolean hasGrades() {
        return !grades.isEmpty();
    }

    public double getAverage() {
        if (!hasGrades()) return 0.0;
        int sum = 0;
        for (Grade g : grades) {
            sum += g.getScore();
        }
        return (double) sum / grades.size();
    }

    public Grade getHighest() {
        if (!hasGrades()) return null;
        Grade highest = grades.get(0);
        for (Grade g : grades) {
            if (g.getScore() > highest.getScore()) {
                highest = g;
            }
        }
        return highest;
    }

    public Grade getLowest() {
        if (!hasGrades()) return null;
        Grade lowest = grades.get(0);
        for (Grade g : grades) {
            if (g.getScore() < lowest.getScore()) {
                lowest = g;
            }
        }
        return lowest;
    }

}
