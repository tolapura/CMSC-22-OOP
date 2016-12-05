package lab_10;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> listOfStudents = new ArrayList<>();
        FileReading fr = new FileReading("C:\\Users\\USER\\Desktop\\StudentInformationSystem.txt");
        fr.readFile(listOfStudents);
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

                for (Student s: listOfStudents) {
                    if (!(s.getStudentNumber().equals(studentNum))){
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
                        Student student = new Student(studentNum, firstName, initial, lastName, course, yearLevel);
                        listOfStudents.add(student);
                        System.out.println("OUTPUT ADDED!");
                        System.out.print(student);
                        break;
                    }
                    else if(s.getStudentNumber().equals(studentNum)){
                        System.out.println("Student already exists!");
                    }
                }
            }

            else if (choice == 2) {
                System.out.print("Enter student number: ");
                String cute = sc.nextLine();
                String num = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < listOfStudents.size(); i++){
                    if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                        System.out.print(listOfStudents.get(i));
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.out.println("STUDENT NOT FOUND!");
            }

            else if (choice == 3) {
                System.out.print("Enter student number: ");
                String cute = sc.nextLine();
                String num = sc.nextLine();
                boolean deleted = false;
                for (int i = 0; i < listOfStudents.size(); i++){
                    if (listOfStudents.get(i).getStudentNumber().equals(num)) {
                        listOfStudents.remove(i);
                        deleted = true;
                        break;
                    }
                }
                if (!deleted)
                    System.out.println("STUDENT NOT FOUND!");
            }

            else if (choice == 4){
                System.out.print("Enter student number: ");
                String cute = sc.nextLine();
                String num = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < listOfStudents.size(); i++){
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
                        System.out.println("Updated information:\n" + listOfStudents.get(i));
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.out.println("STUDENT NOT FOUND!");
            } else if (choice == 5) {
                FileWriting fw = new FileWriting("C:\\Users\\USER\\Desktop\\StudentInformationSystem.txt");
                fw.writeFile(listOfStudents);
            }
            else if(choice == 6){
                for(Student s: listOfStudents){
                    System.out.print(s);
                }
            }
        } while (choice != 7);
        System.out.println("Goodbye! (っ◕‿◕)っ");
    }
}