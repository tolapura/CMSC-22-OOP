package lab_10;

public class Student {

    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel){
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
    }
    public String getFirstName(){ return firstName; }
    public void setFirstName(String name){ firstName = name; }
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String num) { studentNumber = num; }
    public char getMiddleInitial() { return middleInitial; }
    public void setMiddleInitial(char initial) { middleInitial = initial; }
    public String getLastName() { return lastName; }
    public void setLastName(String name) { lastName = name; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public int getYearLevel() { return yearLevel; }
    public void setYearLevel(int yearLevel) { this.yearLevel = yearLevel; }
    public String toString() {
        return String.format("Student Number: %s\nName: %s, %s %c.\nProgram: %s\nYear Level: %d\n",
                studentNumber, lastName, firstName, middleInitial, course, yearLevel);
    }
}
