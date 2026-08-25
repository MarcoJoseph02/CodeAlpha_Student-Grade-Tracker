//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

    Scanner scanner = new Scanner(System.in);
    GradeTracker tracker = new GradeTracker();
    boolean running = true;

    while (running) {
        printMenu();
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.print("Enter student name: ");
                tracker.addStudent(scanner.nextLine().trim());
                break;

            case "2":
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine().trim();
                System.out.print("Enter subject: ");
                String subject = scanner.nextLine().trim();
                System.out.print("Enter score (0-100): ");
                try {
                    int score = Integer.parseInt(scanner.nextLine().trim());
                    tracker.addGradeToStudent(studentName, subject, score);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number.");
                }
                break;

            case "3":
                System.out.print("Enter student name: ");
                tracker.printStudentReport(scanner.nextLine().trim());
                break;

            case "4":
                tracker.printSummaryReport();
                break;

            case "5":
                running = false;
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid choice, try again.");
        }
    }
    scanner.close();
}

    private static void printMenu() {
        System.out.println("\n===== Student Grade Tracker =====");
        System.out.println("1. Add student");
        System.out.println("2. Add grade to student");
        System.out.println("3. View student report");
        System.out.println("4. View summary report (all students)");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

