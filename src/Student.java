// Question 5a: Creating the Student model class with private fields
public class Student {

    private int studentNumber;
    private String studentName;
    private String programme;
    private int yearOfStudy;

    // Question 5a: Constructor to initialize the object
    public Student(int studentNumber, String studentName, String programme, int yearOfStudy){
        this.studentNumber = studentNumber;
        this.studentName = studentName;
        this.programme = programme;
        this.yearOfStudy = yearOfStudy;
    }

    // Question 5a: Getters and setters for encapsulation
    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    // Question 5a: toString method to easily print the student details
    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", studentName='" + studentName + '\'' +
                ", programme='" + programme + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }
}