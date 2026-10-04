// Question 5a: Creating the Appointment model class
public class Appointment {

    private int appointmentID;
    private int appointmentStudentNumber;
    private int appointmentTutorID;
    private String subject;
    private String date;
    private String timeSlot;
    private String status;

    public Appointment(int appointmentID, int appointmentStudentNumber, int appointmentTutorID, String subject, String date, String timeSlot, String status) {
        this.appointmentID = appointmentID;
        this.appointmentStudentNumber = appointmentStudentNumber;
        this.appointmentTutorID = appointmentTutorID;
        this.subject = subject;
        this.date = date;
        this.timeSlot = timeSlot;
        this.status = status;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public int getAppointmentStudentNumber() {
        return appointmentStudentNumber;
    }

    public void setAppointmentStudentNumber(int appointmentStudentNumber) {
        this.appointmentStudentNumber = appointmentStudentNumber;
    }

    public int getAppointmentTutorID() {
        return appointmentTutorID;
    }

    public void setAppointmentTutorID(int appointmentTutorID) {
        this.appointmentTutorID = appointmentTutorID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment: " + "\n" +
                "Appointment ID = " + appointmentID + "\n" +
                ", Appointment Student Number = " + appointmentStudentNumber + "\n" +
                ", Appointment Tutor ID = " + appointmentTutorID + "\n" +
                ", subject = '" + subject + '\'' + "\n" +
                ", date = '" + date + '\'' + "\n" +
                ", timeSlot = '" + timeSlot + '\'' + "\n" +
                ", status = '" + status + '\'' + "\n" +
                '}';
    }
}