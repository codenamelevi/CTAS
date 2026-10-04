// Question 5a: Creating the Tutor model class
public class Tutor {

    private int tutorID;
    private String tutorName;
    private String subjectArea;
    private int maximumAppointmentsPerDay;

    // Constructor
    public Tutor(int tutorID, String tutorName, String subjectArea, int maximumAppointmentsPerDay) {
        this.tutorID = tutorID;
        this.tutorName = tutorName;
        this.subjectArea = subjectArea;
        this.maximumAppointmentsPerDay = maximumAppointmentsPerDay;
    }

    // Getters and setters
    public int getTutorID() {
        return tutorID;
    }

    public void setTutorID(int tutorID) {
        this.tutorID = tutorID;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    public int getMaximumAppointmentsPerDay() {
        return maximumAppointmentsPerDay;
    }

    public void setMaximumAppointmentsPerDay(int maximumAppointmentsPerDay) {
        this.maximumAppointmentsPerDay = maximumAppointmentsPerDay;
    }

    @Override
    public String toString() {
        return "Tutor: " + "\n" +
                " Tutor ID = " + tutorID + "\n" +
                ", Tutor Name = '" + tutorName + '\'' + "\n" +
                ", Subject Area = '" + subjectArea + '\'' + "\n" +
                ", Maximum Appointments Per Day = " + maximumAppointmentsPerDay + "\n" +
                '}';
    }
}