import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentManager {

    // Question 3a: Parallel arrays for basic appointment records
    static int[] appointmentID             = new int[5];
    static int[] appointmentStudentNumber  = new int[5];
    static int[] appointmentTutorID        = new int[5];
    static String[] subject                = new String[5];
    static String[] date                   = new String[5];
    static String[] timeSlot               = new String[5];
    static String[] status                 = new String[5];

    static int appointmentCount = 0;

    // Question 5c: ArrayList to store the custom objects
    static ArrayList<Appointment> appointmentslist = new ArrayList<>();

    public static void appointmentBooking(Scanner scanner) {
        System.out.println("Welcome to Appointment Booking!\n");
        System.out.println("Please supply the following: ");

        System.out.println("Please enter the Appointment ID: ");

        while(!scanner.hasNextInt()){
            System.out.println("That's not a number. Please enter the student number: ");
            scanner.next();
        }
        int newAppointmentId = scanner.nextInt();
        scanner.nextLine();

        // Question 3a: Logic to reject duplicate appointment IDs
        boolean isDuplicateAppointmentID;
        do {
            isDuplicateAppointmentID = false;

            for (int i = 0; i < appointmentCount; i++) {
                if (appointmentID[i] == newAppointmentId)
                    isDuplicateAppointmentID = true;
            }

            if (isDuplicateAppointmentID) {
                System.out.println("Rejected: Appointment ID already exists!");
                System.out.println("Please enter the Appointment ID: ");
                newAppointmentId = scanner.nextInt();
                scanner.nextLine();
            }
        } while (isDuplicateAppointmentID);

        appointmentID[appointmentCount] = newAppointmentId;

        System.out.println("Please enter the Student Number: ");

        while(!scanner.hasNextInt()){
            System.out.println("That's not a number. Please enter the student number: ");
            scanner.next();
        }

        int newAppointmentStudentNumber = scanner.nextInt();
        scanner.nextLine();

        // Question 3a: Logic that only accepts existing students
        boolean studentExists = false;
        do {
            for (int i = 0; i < StudentManager.studentCount; i++) {
                if (StudentManager.studentNumber[i] == newAppointmentStudentNumber)
                    studentExists = true;
            }

            if (!studentExists) {
                System.out.println("Student Number does not exist!");
                System.out.println("Please enter the Student Number: ");

                while(!scanner.hasNextInt()){
                    System.out.println("That's not a number. Please enter the student number: ");
                    scanner.next();
                }
                newAppointmentStudentNumber = scanner.nextInt();
                scanner.nextLine();
            }
        } while (!studentExists);

        appointmentStudentNumber[appointmentCount] = newAppointmentStudentNumber;

        System.out.println("Please enter the Tutor ID: ");

        while(!scanner.hasNextInt()){
            System.out.println("That's not a number. Please enter the student number: ");
            scanner.next();
        }

        int newAppointmentTutorID = scanner.nextInt();
        scanner.nextLine();

        // Question 3a: Logic that only accepts existing tutors
        boolean tutorExists = false;
        do {
            for (int i = 0; i < TutorManager.tutorCount; i++) {
                if (TutorManager.tutorID[i] == newAppointmentTutorID)
                    tutorExists = true;
            }

            if (!tutorExists) {
                System.out.println("Tutor ID does not exist!");
                System.out.println("Please enter the Tutor ID: ");

                while(!scanner.hasNextInt()){
                    System.out.println("That's not a number. Please enter the student number: ");
                    scanner.next();
                }
                newAppointmentTutorID = scanner.nextInt();
                scanner.nextLine();
            }
        } while (!tutorExists);

        appointmentTutorID[appointmentCount] = newAppointmentTutorID;

        // Question 3a: Limit a student to only two active Booked appointments (BR5)
        int bookedCount = 0;
        for(int i = 0; i < appointmentCount; i ++) {
            if (appointmentStudentNumber[i] == newAppointmentStudentNumber && status[i].equals("Booked")) {
                bookedCount++;
            }
        }
        if(bookedCount >= 2){
            System.out.println("Rejected: This student already has 2 active Booked appointments.");
            return;
        }

        // Question 3a: Prevent tutor from exceeding daily maximum (BR6)
        int tutorMax = 0;
        for(int i = 0; i < TutorManager.tutorCount; i++){
            if(TutorManager.tutorID[i] == newAppointmentTutorID){
                tutorMax = TutorManager.maximumAppointmentsPerDay[i] ;
            }
        }

        int tutorBookedCount = 0;
        for(int i = 0; i < appointmentCount; i ++) {
            if (appointmentTutorID[i] == newAppointmentTutorID && status[i].equals("Booked")) {
                tutorBookedCount++;
            }
        }

        if(tutorMax <= tutorBookedCount){
            System.out.println("Rejected: This tutor has reached their daily maximum of " + tutorMax + " appointments.");
            return;
        }

        System.out.println("Please enter the subject: ");
        String newSubject = scanner.nextLine();
        subject[appointmentCount] = newSubject;

        System.out.println("Please enter the date: ");
        String newDate = scanner.nextLine();
        date[appointmentCount] = newDate;

        System.out.println("Please enter the time slot: ");
        String newTimeSlot = scanner.nextLine();
        timeSlot[appointmentCount] = newTimeSlot;

        // Question 3a: Setting a valid new appointment status to Booked
        String newStatus = "Booked";
        status[appointmentCount] = newStatus;

        // Question 5c: Creating the Appointment object and pushing it to the ArrayList
        appointmentslist.add(new Appointment(newAppointmentId, newAppointmentStudentNumber, newAppointmentTutorID, newSubject, newDate, newTimeSlot, newStatus));

        appointmentCount++;
    }

    // Question 5d: Looping through the ArrayList to display all objects
    public static void displayAppointmentsFromList(Scanner scanner) {
        if(appointmentslist.isEmpty()){
            System.out.println("No Appointments");
            return;
        }

        System.out.println("--- All Appointments ---");
        for(Appointment a : appointmentslist){
            System.out.println(a.toString());
        }

        // Question 3c: Old version of displayAppointments method using arrays (Kept for evidence)
        /* if(appointmentCount == 0){
            System.out.println("No Appointments");
            return;
        }

        System.out.println("--- All Appointments ---");

        for(int i = 0; i < appointmentCount; i++){
            System.out.println("Appointment ID: " + appointmentID[i]);
            System.out.println("Student Number: " + appointmentStudentNumber[i]);
            System.out.println("Tutor ID: " + appointmentTutorID[i]);
            System.out.println("Subject: " + subject[i]);
            System.out.println("Date: " + date[i]);
            System.out.println("Time Slot: " + timeSlot[i]);
            System.out.println("Status: " + status[i]);
        }*/
    }

    // Question 3c & 5d: Searching the ArrayList by ID
    public static void searchAppointmentByIDFromList(Scanner scanner){
        if(appointmentslist.isEmpty()){
            System.out.println("No appointments to search.");
            return;
        }

        System.out.println("Enter the appointment ID to search for:");

        while(!scanner.hasNextInt()){
            System.out.println("That's not a number. Please enter the appointment ID : ");
            scanner.next();
        }

        int searchID = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        for(Appointment a : appointmentslist){
            if(searchID == a.getAppointmentID()){
                found = true;
                System.out.println(a.toString());
                break;
            }
        }
        if(!found){
            System.out.println("No records with appointment ID found.");
        }
    }

    // Question 3c: Old version of searchAppointmentByID using arrays (Kept for evidence)
    /* public static void searchAppointmentByID(Scanner scanner){
        if(appointmentCount == 0){
            System.out.println("No appointments to search.");
            return;
        }

        System.out.println("Enter the appointment ID to search for:");

        while(!scanner.hasNextInt()){
            System.out.println("That's not a number. Please enter the appointment ID : ");
            scanner.next();
        }

        int searchID = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        for(int i = 0; i < appointmentCount; i++){
            if(appointmentID[i] == searchID){
                found = true;
                System.out.println("Appointment ID found!");
                System.out.println("Appointment ID: " + appointmentID[i]);
                System.out.println("Student Number: " + appointmentStudentNumber[i]);
                System.out.println("Tutor ID: " + appointmentTutorID[i]);
                System.out.println("Subject: " + subject[i]);
                System.out.println("Date: " + date[i]);
                System.out.println("Time Slot: " + timeSlot[i]);
                System.out.println("Status: " + status[i]);
                break;
            }
        }
        if(!found){
            System.out.println("No records with appointment ID found.");
        }
    }*/

    // Question 3c & 5c: Reusable method to count booked apps using the list
    public static void countBookedAppointmentsFromList( ){
        int countBooked = 0;

        for(Appointment a : appointmentslist) {
            if(a.getStatus().equals("Booked")){
                countBooked++;
            }
        }
        if(appointmentslist.size() > 0){
            System.out.println("Total Booked Appointments: " + countBooked);
        }else{
            System.out.println("There are no booked appointments to display.");
        }
    }

    // Question 3c: Old version of countBookedAppointments using arrays (Kept for evidence)
    /*public static void countBookedAppointments( ){

        int countBooked = 0;

        for(int i = 0; i < appointmentCount; i++) {
            if(status[i].equals("Booked")){
                countBooked++;
            }
        }
        if(appointmentCount > 0){
            System.out.println("Total Booked Appointments: " + countBooked);
        }else{
            System.out.println("There are no booked appointments to display.");
        }
    }*/

    // Question 3c & 5c: Calculate completion percentage safely using double math
    public static void calculateCompletedPercentageFromList( ){
        int countCompleted = 0;
        double percentage = 0.0;

        for(Appointment a : appointmentslist){
            if(a.getStatus().equals("Completed")){
                countCompleted++;
            }
        }
        if(appointmentslist.size() > 0){
            percentage = (double) countCompleted / appointmentslist.size() * 100;
            System.out.println("Completed Appointments: " + percentage);
        }else{
            System.out.println("There are no appointments to calculate.");
        }
    }

    // Question 3c: Old version of calculateCompletedPercentage using arrays (Kept for evidence)
    /* public static void calculateCompletedPercentage( ){

        int countCompleted = 0;
        double percentage = 0.0;

        for(int i = 0; i < appointmentCount; i++){
            if(status[i].equals("Completed")){
                countCompleted++;
            }
        }
        if(appointmentCount > 0){
            percentage = (double) countCompleted / appointmentCount * 100;
            System.out.println("Completed Appointments: " + percentage);
        }else{
            System.out.println("There are no appointments to calculate.");
        }
    }*/

    // Question 3c & 5c: Status reports finding linked tutor info
    public static void displayAppointmentsByStatusFromList(Scanner scanner) {
        int choiceByStatus;

        do {
            System.out.println("Select the appointment status would you like to view:" + "\n" +
                    "1. Booked" + "\n" +
                    "2. Completed" + "\n" +
                    "3. Exit");

            choiceByStatus = scanner.nextInt();
            scanner.nextLine();

            boolean statusFound = false;

            switch (choiceByStatus) {
                case 1:
                    for(Appointment a : appointmentslist) {
                        if (a.getStatus().equals("Booked")) {
                            statusFound = true;

                            System.out.println("Appointment status found!\n");
                            System.out.println("------------------ Appointment Details ------------------\n");
                            System.out.println(a.toString());

                            // Nested loop to link the tutor object to the appointment
                            for (Tutor t : TutorManager.tutorslist) {
                                if (t.getTutorID() == a.getAppointmentTutorID()) {
                                    System.out.println("------------------ Tutor Details ------------------\n");
                                    System.out.println(t.toString());
                                }
                            }
                        }
                    }
                    if(!statusFound) {
                        System.out.println("No appointments has the chosen status.");
                    }
                    break;

                case 2:
                    for(Appointment a : appointmentslist) {
                        if (a.getStatus().equals("Completed")) {
                            statusFound = true;
                            System.out.println(a.toString());

                            for (Tutor t : TutorManager.tutorslist) {
                                if (t.getTutorID() == a.getAppointmentTutorID()) {
                                    System.out.println("------------------ Tutor Details ------------------\n");
                                    System.out.println(t.toString());
                                }
                            }
                        }
                    }
                    if(!statusFound){
                        System.out.println("No appointments has the chosen status.");
                    }
                    break;

                case 3:
                    System.out.println("Good Bye !!");
                    break;

                default:
                    System.out.println("Invalid option chosen\n");
                    break;
            }
        } while(choiceByStatus != 3);
    }

    // Question 3c: Old version of displayAppointmentsByStatus using arrays (Kept for evidence)
    /*     public static void displayAppointmentsByStatus(Scanner scanner) {
        int choiceByStatus;

        do {
            System.out.println("Select the appointment status would you like to view:" +
                    "1. Booked" + "\n" +
                    "2. Completed" + "\n" +
                    "3. Exit");

            choiceByStatus = scanner.nextInt();
            scanner.nextLine();

            boolean statusFound = false;
            switch (choiceByStatus) {
                case 1:



                    for(int i = 0; i < appointmentCount; i ++) {
                        if (status[i].equals("Booked")) {
                            statusFound = true;



                            System.out.println("Appointment status found!\n");
                            System.out.println("------------------ Appointment Details ------------------\n");

                            System.out.println("Appointment ID: " + appointmentID[i]);
                            System.out.println("Student Number: " + appointmentStudentNumber[i]);
                            System.out.println("Tutor ID: " + appointmentTutorID[i]);
                            System.out.println("Subject: " + subject[i]);
                            System.out.println("Date: " + date[i]);
                            System.out.println("Time Slot: " + timeSlot[i]);
                            System.out.println("Status: " + status[i]);


                            for (int j = 0; j < TutorManager.tutorCount; j++) {
                                if (TutorManager.tutorID[j] == appointmentTutorID[i]) {
                                    System.out.println("------------------ Tutor Details ------------------\n");

                                    System.out.println("Tutor ID: " + TutorManager.tutorID[j] + "\n" +
                                            "Tutor Name: " + TutorManager.tutorName[j] + "\n" +
                                            "Subject Area: " + TutorManager.subjectArea[j] + "\n" +
                                            "Max Appointments: " + TutorManager.maximumAppointmentsPerDay[j]);
                                }
                            }
                        }
                    }
                    if(!statusFound) {
                        System.out.println("No appointments has the chosen status.");

                    } break;

                case 2:
                    for(int i = 0; i < appointmentCount; i ++) {
                        if (status[i].equals("Completed")) {
                            statusFound = true;


                            System.out.println("Appointment status found!\n");
                            System.out.println("------------------ Appointment Details ------------------\n");

                            System.out.println("Appointment ID: " + appointmentID[i]);
                            System.out.println("Student Number: " + appointmentStudentNumber[i]);
                            System.out.println("Tutor ID: " + appointmentTutorID[i]);
                            System.out.println("Subject: " + subject[i]);
                            System.out.println("Date: " + date[i]);
                            System.out.println("Time Slot: " + timeSlot[i]);
                            System.out.println("Status: " + status[i]);


                            for (int j = 0; j < TutorManager.tutorCount; j++) {
                                if (TutorManager.tutorID[j] == appointmentTutorID[i]) {

                                    System.out.println("------------------ Tutor Details ------------------\n");

                                    System.out.println("Tutor ID: " + TutorManager.tutorID[j] + "\n" +
                                            "Tutor Name: " + TutorManager.tutorName[j] + "\n" +
                                            "Subject Area: " + TutorManager.subjectArea[j] + "\n" +
                                            "Max Appointments: " + TutorManager.maximumAppointmentsPerDay[j]);
                                }
                            }

                        }
                    }if(!statusFound){
                    System.out.println("No appointments has the chosen status.");
                }

                    break;
                case 3:
                    System.out.println("Good Bye !!");
                    break;
                default:
                    System.out.println("Invalid option chosen\n");
                    break;
            }
        }while(choiceByStatus != 3);
    }*/
}