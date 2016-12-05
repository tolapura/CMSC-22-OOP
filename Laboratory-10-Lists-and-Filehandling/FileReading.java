package lab_10;
import java.io.*;
import java.util.List;

public class FileReading {
    private String path;
    public FileReading(String path){ this.path = path; }
    public void readFile(List<Student> listOfStudents){
        try {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(path));
            while ((sCurrentLine = br.readLine()) != null) {
                String studentNumber = sCurrentLine;
                String firstName = br.readLine();
                char middleInitial;
                String temp = br.readLine();
                if (temp.equals("")) {
                    middleInitial = 32;
                }else{
                    middleInitial = temp.charAt(0);
                }
                String lastName = br.readLine();
                String course = br.readLine();
                String yearLevel = br.readLine();
                Student student = new Student(studentNumber, firstName, middleInitial, lastName, course, 4);
                listOfStudents.add(student);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}