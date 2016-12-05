package serialization;

import java.io.Serializable;
import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    private static final String FILE_NAME = "C:\\Users\\USER\\IdeaProjects\\serialization\\src\\serialization\\FILE.ser";

    private static boolean checkStudentNum(List<Student> studentList, String studentNum) {
        for (Student s : studentList) {
            if (s.getStudentNumber().equals(studentNum)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<>();
        File fin = new File(FILE_NAME);
        FileInputStream fileIn;
        ObjectInputStream in_;
        FileOutputStream fileOut;
        ObjectOutputStream out;

        try {

            if (fin.length() != 0) {
                fileIn = new FileInputStream(FILE_NAME);
                in_ = new ObjectInputStream(fileIn);
                listOfStudents = (List<Student>) in_.readObject();
                in_.close();
                fileIn.close();
            }


            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("STUDENT INFORMATION SYSTEM");
                System.out.println("\t1. Register a Student.\n\t2. Retrieve Student Information.\n\t3. Delete a Student.\n\t4. Edit a Student.\n\t5. Save.\n\t6. Display.\n\t7. Exit.\n");
                System.out.println("Press the number of your choice: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter student number: ");
                    String cute = sc.nextLine();
                    String studentNum = sc.nextLine();
                    if (!checkStudentNum(listOfStudents, studentNum)) {
                        System.out.print("Enter first name: ");
                        String firstName = sc.nextLine();
                        System.out.print("Enter middle initial: ");
                        String in = sc.nextLine();
                        char initial;
                        if (in.equals("")) {
                            initial = 32;
                        } else {
                            initial = in.charAt(0);
                        }
                        System.out.print("Enter last name: ");
                        String lastName = sc.nextLine();
                        System.out.print("Enter program/course: ");
                        String course = sc.nextLine();
                        System.out.print("Enter year level: ");
                        int yearLevel = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Crush's Name: ");
                        String crushName = sc.nextLine();
                        System.out.println("Enter Course code: ");
                        String courseCode = sc.nextLine();
                        System.out.println("Enter Course description: ");
                        String courseDescription = sc.nextLine();
                        Course courseObj = new Course(courseCode, courseDescription);
                        Student student = new Student(studentNum, firstName, initial, lastName,
                                course, yearLevel, crushName, courseObj);
                        listOfStudents.add(student);
                        System.out.println("OUTPUT ADDED!");
                        System.out.print(student);
                    } else {
                        System.out.println("Student exists!");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter student number: ");
                    String cute = sc.nextLine();
                    String num = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < listOfStudents.size(); i++) {
                        if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                            System.out.print(listOfStudents.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("STUDENT NOT FOUND!");
                } else if (choice == 3) {
                    System.out.print("Enter student number: ");
                    String cute = sc.nextLine();
                    String num = sc.nextLine();
                    boolean deleted = false;
                    for (int i = 0; i < listOfStudents.size(); i++) {
                        if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                            listOfStudents.remove(i);
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted)
                        System.out.println("STUDENT NOT FOUND!");
                } else if (choice == 4) {
                    System.out.print("Enter student number: ");
                    String cute = sc.nextLine();
                    String num = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < listOfStudents.size(); i++) {
                        if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                            System.out.println(listOfStudents.get(i));
                            System.out.print("Set first name to: ");
                            listOfStudents.get(i).setFirstName(sc.nextLine());
                            System.out.print("Set middle initial to: ");
                            listOfStudents.get(i).setMiddleInitial(sc.nextLine().charAt(0));
                            System.out.print("Set last name to: ");
                            listOfStudents.get(i).setLastName(sc.nextLine());
                            System.out.print("Set course: ");
                            listOfStudents.get(i).setCourse(sc.nextLine());
                            System.out.print("Set year level: ");
                            listOfStudents.get(i).setYearLevel(sc.nextInt());
                            sc.nextLine();
                            System.out.println("Set Crush's Name: ");
                            listOfStudents.get(i).setCrushName(sc.nextLine());
                            System.out.print("Set Favorite Course: \n");
                            System.out.print("\tCourse code: ");
                            String courseCode = sc.nextLine();
                            System.out.print("\tCourse description: ");
                            String courseDescription = sc.nextLine();
                            Course newCourse = new Course(courseCode, courseDescription);
                            listOfStudents.get(i).setFaveSubject(newCourse);
                            System.out.println("Updated information:\n" + listOfStudents.get(i));
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("STUDENT NOT FOUND!");
                } else if (choice == 5) {
                        fileOut = new FileOutputStream(fin);
                        out = new ObjectOutputStream(fileOut);
                        out.writeObject(listOfStudents);
                        out.close();
                        fileOut.close();
                } else if (choice == 6) {
                    for (Student s : listOfStudents) {
                        System.out.print(s);
                    }
                }
            } while (choice != 7);
            System.out.println("Goodbye! (っ◕‿◕)っ");
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Student class not found");
            c.printStackTrace();
            return;
        }
    }
}