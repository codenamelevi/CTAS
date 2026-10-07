# CTAS — Student and Tutor Appointment System


A Java console application for registering students and tutors, booking appointments, searching appointment records, and viewing appointment reports.


## Features



- Register students with a student number, name, programme, and year of study

- Register tutors with a tutor ID, name, subject area, and daily appointment limit

- Book appointments for registered students and tutors

- View all appointments or search by appointment ID

- View booked appointments and appointment completion statistics

- Validate numeric menu input and reject duplicate IDs

- Limit students to two booked appointments and enforce tutor appointment limits



## Requirements



- Java Development Kit (JDK)

- IntelliJ IDEA or another Java IDE



## Running the Application



1. Open the project in your Java IDE.

2. Run `CTASApp.java`.

3. Use the console menu to register students and tutors, book appointments, search records, or view reports.



## Project Structure


Plain text






```
├── CTASApp.java             # Application entry point and main menu
├── Appointment.java         # Appointment data model
├── AppointmentManager.java  # Appointment booking, display, search, and reports
├── ReportManager.java       # Reports menu
├── Student.java             # Student data model
├── StudentManager.java      # Student registration and display
├── Tutor.java               # Tutor data model
└── TutorManager.java        # Tutor registration and display

```





## Notes



- Records are held in memory and are not saved between application runs.

- The current implementation uses fixed-size arrays with space for up to five students, tutors, and appointments.

- Appointments are created with the `Booked` status.

- The application is console-based and has no graphical interface.
