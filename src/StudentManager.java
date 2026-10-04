import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    static int studentCount = 0;

    // Question 2a: Fixed arrays for early data storage prototype
    static int[] studentNumber = new int[5];
    static String[] studentName = new String[5];
    static String[] programme = new String[5];
    static int[] yearOfStudy = new int[5];

    // Question 5c: Replacing/supplementing arrays with an ArrayList for better OOP
    static ArrayList<Student> studentslist = new ArrayList<>();

    public static void registerStudent(Scanner scanner) {
        System.out.println("Welcome to Student Registration!");

        System.out.println("Please enter the student number: ");

        // Question 3b: Input validation to ensure numbers only
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number. Please enter the student number: ");
            scanner.next();
        }

        int newStudentNumber = scanner.nextInt();
        scanner.nextLine();

        // Question 3b: Validating that the student number is positive
        while (newStudentNumber <= 0) {
            System.out.println("Invalid Student Number");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number. Please enter the student number: ");
                scanner.next();
            }
            newStudentNumber = scanner.nextInt();
            scanner.nextLine();
        }

        // Question 3b: Rejecting duplicate student numbers
        boolean isDuplicateStudentNumber;
        do {
            isDuplicateStudentNumber = false;

            for (int i = 0; i < studentCount; i++) {
                if (studentNumber[i] == newStudentNumber) {
                    isDuplicateStudentNumber = true;
                }
            }

            if (isDuplicateStudentNumber) {
                System.out.println("Rejected: Student number already exists.");
                System.out.println("Please enter the student number: ");

                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number. Please enter the student number: ");
                    scanner.next();
                }

                newStudentNumber = scanner.nextInt();
                scanner.nextLine();
            }
        } while (isDuplicateStudentNumber);

        // Question 2b: Storing valid input into the array
        studentNumber[studentCount] = newStudentNumber;

        System.out.println("Please enter the student full name: ");
        String newStudentName = scanner.nextLine();

        // Question 3b: Rejecting blank names
        while (newStudentName.isEmpty()) {
            System.out.println("Input rejected. You must type something!\n");
            System.out.println("Please enter the student full name: ");
            newStudentName = scanner.nextLine();
        }

        studentName[studentCount] = newStudentName;

        System.out.println("Please enter the student programme: ");
        String newProgramme = scanner.nextLine();
        programme[studentCount] = newProgramme;

        System.out.println("Please enter the student year of study: ");

        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number. Please enter the year of study: ");
            scanner.next();
        }
        int newYearOfStudy = scanner.nextInt();
        scanner.nextLine();
        yearOfStudy[studentCount] = newYearOfStudy;

        // Question 5c: Creating the object and adding it to the ArrayList
        studentslist.add(new Student(newStudentNumber, newStudentName, newProgramme, newYearOfStudy));

        studentCount++;
    }

    public static void printAllStudents() {
        System.out.println("--- Registered Students ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(studentNumber[i] + " | " + studentName[i] + " | " + programme[i] + " | " + yearOfStudy[i]);
        }
    }
}