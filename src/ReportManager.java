import java.util.Scanner;

public class ReportManager {

    // Helper menu class to handle the reporting switch cases
    public static void reports (Scanner scanner){
        int reportMenuChoice;

        do {
            System.out.println("Welcome to Reports!");
            System.out.println("\nReports Menu\n");

            System.out.println("1. Count Booked Appointments");
            System.out.println("2. Calculate Completed Appointments Percentage");
            System.out.println("3. Display Appointments by Status");
            System.out.println("4. Return to Main Menu");

            System.out.println("\nPlease choose an option: \n");

            while(!scanner.hasNextInt()){
                System.out.println("That's not a number. Please enter a number: ");
                scanner.next();
            }

            reportMenuChoice = scanner.nextInt();
            scanner.nextLine();

            // Calling the static methods from AppointmentManager based on choice
            switch (reportMenuChoice) {
                case 1:
                    AppointmentManager.countBookedAppointmentsFromList();
                    break;
                case 2:
                    AppointmentManager.calculateCompletedPercentageFromList();
                    break;
                case 3:
                    AppointmentManager.displayAppointmentsByStatusFromList(scanner);
                    break;
                case 4:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid option chosen\n");
                    break;
            }
        } while (reportMenuChoice != 4) ;
    }
}