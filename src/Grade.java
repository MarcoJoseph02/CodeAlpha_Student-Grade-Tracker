import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grade {
    private final String subject;
    private final int score;

    public Grade(String subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return subject + ": " + score;
    }
}
