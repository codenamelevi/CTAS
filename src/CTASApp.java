import java.util.Scanner;

public class CTASApp {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Question 5b: Creating sample objects to show encapsulation and testing
        Student student1 = new Student(5326, "Levi","Computer Science", 2026);
        Student student2 = new Student(1234, "John", "Applied Maths", 2026);
        System.out.println(student1.toString());
        System.out.println(student2.toString());

        Tutor tutor1 = new Tutor(5432, "Dover", "Chemical Engineering", 3);
        Tutor tutor2 = new Tutor(2345, "Gabby", "Mechanical Engineering", 3);
        System.out.println(tutor1.toString());
        System.out.println(tutor2.toString());

        Appointment appointment1 = new Appointment(1234, 4567, 5432, "Math", "04/08/26", "14:30", "Booked");
        Appointment appointment2 = new Appointment(3432, 7867, 4454, "chem", "07/08/26", "14:45", "Booked");
        System.out.println(appointment1.toString());
        System.out.println(appointment2.toString());

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Question 1c: Implementing a repeating menu using a do-while loop
        do {
            System.out.println("Welcome to the menu\n");
            System.out.println("1. Student Registration.");
            System.out.println("2. Tutor Registration.");
            System.out.println("3. Appointment Booking.");
            System.out.println("4. Display Appointments.");
            System.out.println("5. Reports");
            System.out.println("6. Search Appointment by ID.");
            System.out.println("7. Exit");

            System.out.println("\nPlease choose an option: ");

            // Question 3b: Input validation to stop the app from crashing if letters are typed
            while(!scanner.hasNextInt()){
                System.out.println("Invalid input. Please enter a number: \n");
                scanner.next();
            }

            choice = scanner.nextInt();

            // Processing the menu choice
            switch (choice) {
                case 1:
                    StudentManager.registerStudent(scanner);
                    break;
                case 2:
                    TutorManager.registerTutor(scanner);
                    break;
                case 3:
                    AppointmentManager.appointmentBooking(scanner);
                    break;
                case 4:
                    AppointmentManager.displayAppointmentsFromList(scanner);
                    break;
                case 5:
                    ReportManager.reports(scanner);
                    break;
                case 6:
                    AppointmentManager.searchAppointmentByIDFromList(scanner);
                    break;
                case 7:
                    System.out.println("Good Bye !!");
                    break;
                default:
                    System.out.println("Invalid option chosen\n");
                    break;
            }

            // Just printing the lists at the bottom of the loop to keep track of data
            StudentManager.printAllStudents();
            TutorManager.printAllTutors();

        } while (choice != 7);
    }
}