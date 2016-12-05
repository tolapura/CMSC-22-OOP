package lab_10;
import java.io.*;
import java.util.List;

public class FileWriting {
    public String path;
    public FileWriting(String path) {this.path = path; }
    public void writeFile(List<Student> listOfStudents) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Student s: listOfStudents){
                bw.write(s.getStudentNumber());
                bw.newLine();
                bw.write(s.getFirstName());
                bw.newLine();
                bw.write(s.getMiddleInitial());
                bw.newLine();
                bw.write(s.getLastName());
                bw.newLine();
                bw.write(s.getCourse());
                bw.newLine();
                bw.write(s.getYearLevel() + "");
                bw.newLine();
            }
            bw.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}