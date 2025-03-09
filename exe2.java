import java.util.Scanner;

public class exe2 {
    private static final int MAX_STUDENTS = 100;
    private static final int SUBJECTS = 3;
    private static int[][] studentMarks = new int[MAX_STUDENTS][SUBJECTS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student marks (add [studentID])");
            System.out.println("2. Update student mark (update [studentID] [subjectID])");
            System.out.println("3. Get the average mark of a student (average [studentID])");
            System.out.println("4. Get the average mark for a subject (average_s [subjectID])");
            System.out.println("5. Get the total mark of a student (total [studentID])");
            System.out.println("6. Exit");
            System.out.print("Enter command: ");
            
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            
            if (parts[0].equalsIgnoreCase("add")) {
                int studentID = Integer.parseInt(parts[1]) - 1;
                addStudentMarks(scanner, studentID);
            } else if (parts[0].equalsIgnoreCase("update")) {
                int studentID = Integer.parseInt(parts[1]) - 1;
                int subjectID = Integer.parseInt(parts[2]) - 1;
                updateStudentMark(scanner, studentID, subjectID);
            } else if (parts[0].equalsIgnoreCase("average")) {
                int studentID = Integer.parseInt(parts[1]) - 1;
                System.out.println("Average for student " + (studentID + 1) + ": " + getStudentAverage(studentID));
            } else if (parts[0].equalsIgnoreCase("average_s")) {
                int subjectID = Integer.parseInt(parts[1]) - 1;
                System.out.println("Average for subject " + (subjectID + 1) + ": " + getSubjectAverage(subjectID));
            } else if (parts[0].equalsIgnoreCase("total")) {
                int studentID = Integer.parseInt(parts[1]) - 1;
                System.out.println("Total marks for student " + (studentID + 1) + ": " + getStudentTotal(studentID));
            } else if (parts[0].equalsIgnoreCase("exit")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }
        scanner.close();
    }

    private static void addStudentMarks(Scanner scanner, int studentID) {
        for (int i = 0; i < SUBJECTS; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            studentMarks[studentID][i] = scanner.nextInt();
        }
        scanner.nextLine(); // Consume newline
        System.out.println("Marks added successfully for student " + (studentID + 1));
    }

    private static void updateStudentMark(Scanner scanner, int studentID, int subjectID) {
        System.out.print("Enter new mark for Subject " + (subjectID + 1) + ": ");
        studentMarks[studentID][subjectID] = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Mark updated successfully for student " + (studentID + 1));
    }

    private static double getStudentAverage(int studentID) {
        int total = getStudentTotal(studentID);
        return total / (double) SUBJECTS;
    }

    private static double getSubjectAverage(int subjectID) {
        int sum = 0, count = 0;
        for (int i = 0; i < MAX_STUDENTS; i++) {
            if (studentMarks[i][subjectID] > 0) {
                sum += studentMarks[i][subjectID];
                count++;
            }
        }
        return count == 0 ? 0 : sum / (double) count;
    }

    private static int getStudentTotal(int studentID) {
        int total = 0;
        for (int i = 0; i < SUBJECTS; i++) {
            total += studentMarks[studentID][i];
        }
        return total;
    }
}

