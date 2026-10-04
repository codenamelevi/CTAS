import java.util.ArrayList;
import java.util.Scanner;

public class TutorManager {
    static int tutorCount = 0;

    // Question 2a: Arrays to store tutor records
    public static int[] tutorID = new int[5];
    static String[] tutorName = new String[5];
    static String[] subjectArea = new String[5];
    static int[] maximumAppointmentsPerDay = new int[5];

    // Question 5c: ArrayList for Tutor objects
    static ArrayList<Tutor> tutorslist = new ArrayList<>();

    public static void registerTutor(Scanner scanner) {
        System.out.println("Welcome to Tutor Registration!");

        System.out.println("Please enter the tutor ID: ");

        while(!scanner.hasNextInt()){
            System.out.println("That's not a number. Please enter the Tutor ID: ");
            scanner.next();
        }

        int newTutorID = scanner.nextInt();
        scanner.nextLine();

        // Question 3b: Loop to reject duplicate tutor IDs
        boolean isDuplicateTutorID;
        do {
            isDuplicateTutorID = false;

            for (int i = 0; i < tutorCount; i++) {
                if (tutorID[i] == newTutorID) {
                    isDuplicateTutorID = true;
                }
            }

            if (isDuplicateTutorID) {
                System.out.println("Rejected: Tutor ID already exists.");
                System.out.println("Please enter the Tutor ID: ");

                while(!scanner.hasNextInt()){
                    System.out.println("That's not a number. Please enter the Tutor ID: ");
                    scanner.next();
                }

                newTutorID = scanner.nextInt();
                scanner.nextLine();
            }
        } while (isDuplicateTutorID);

        // Question 2b: Storing the ID in the array
        tutorID[tutorCount] = newTutorID;

        System.out.println("Please enter the tutor full name: ");
        String newTutorName = scanner.nextLine();

        // Question 3b: Reject blank strings
        while(newTutorName.isEmpty()){
            System.out.println("Input rejected. You must type something!\n");
            System.out.println("Please enter the tutor full name: ");
            newTutorName = scanner.nextLine();
        }
        tutorName[tutorCount] = newTutorName;

        System.out.println("Please enter the tutor's subject area: ");
        String newSubjectArea = scanner.nextLine();

        subjectArea[tutorCount] = newSubjectArea;

        System.out.println("Please enter the maximum Appointments PerDay: ");

        while(!scanner.hasNextInt()){
            System.out.println("That's not a number. Please enter the  number: ");
            scanner.next();
        }

        int newMaximumAppointmentsPerDay = scanner.nextInt();
        scanner.nextLine();

        maximumAppointmentsPerDay[tutorCount] = newMaximumAppointmentsPerDay;

        // Question 5c: Creating Tutor object and adding to the list
        tutorslist.add(new Tutor(newTutorID, newTutorName, newSubjectArea, newMaximumAppointmentsPerDay));

        tutorCount++;
    }

    public static void printAllTutors() {
        System.out.println("--- Registered Tutors ---");
        for (int i = 0; i < tutorCount; i++) {
            System.out.println(tutorID[i] + " | " + tutorName[i] + " | " + subjectArea[i] + " | " + maximumAppointmentsPerDay[i]);
        }
    }
}