package serialization;

import java.io.Serializable;

public class Course implements Serializable {
    private String courseCode;
    private String courseDescription;

    public Course() {
        courseCode = "";
        courseDescription = "";
    }
    public Course(String courseCode, String courseDescription) {
        this.courseDescription = courseDescription;
        this.courseCode = courseCode;
    }
    public String getCourseCode() {return courseCode;}
    public String getCourseDescription() {return courseDescription;}
    public void setCourseCode(String courseCode){this.courseCode = courseCode;}
    public void setCourseDescription(String courseDescription) {this.courseDescription = courseDescription;}

    public String toString() {
        return String.format("Course code: %s\nCourse description: %s\n", courseCode, courseDescription);
    }
}