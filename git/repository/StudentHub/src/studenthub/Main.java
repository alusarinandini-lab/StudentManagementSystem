package studenthub;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Total Students");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    boolean exists = false;

                    for (Student stu : students) {
                        if (stu.id == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("ID Already Exists!");
                    } else {
                        Student s = new Student(id, name, age);
                        students.add(s);
                        System.out.println("Student Added Successfully!");
                    }

                    break;

                case 2:

                    if (students.isEmpty()) {
                        System.out.println("No Students Found");
                    } else {

                        for (Student stu : students) {

                            System.out.println("--------------------");
                            System.out.println("ID   : " + stu.id);
                            System.out.println("Name : " + stu.name);
                            System.out.println("Age  : " + stu.age);
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student stu : students) {

                        if (stu.id == searchId) {

                            System.out.println("Student Found!");
                            System.out.println("ID   : " + stu.id);
                            System.out.println("Name : " + stu.name);
                            System.out.println("Age  : " + stu.age);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted =
                            students.removeIf(stu -> stu.id == deleteId);

                    if (deleted) {
                        System.out.println("Student Deleted Successfully!");
                    } else {
                        System.out.println("Student Not Found");
                    }

                    break;

                case 5:

                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Student stu : students) {

                        if (stu.id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            stu.name = sc.nextLine();

                            System.out.print("Enter New Age: ");
                            stu.age = sc.nextInt();

                            updated = true;

                            System.out.println("Student Updated Successfully!");
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student Not Found");
                    }

                    break;

                case 6:

                    System.out.println("Total Students: "
                            + students.size());

                    break;

                case 7:

                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}