package studentManagement;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println("\n1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Update Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Exit");
            System.out.print("Enter  your choice: ");

            int choice =scanner.nextInt();
            switch (choice){
                case 1 :
                    addStudent(scanner);
                    break;
                case 2:
                    database.viewStudents();
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    exit=true;
                    System.out.println("Exiting...!!");
                    break;
                default:
                    System.out.println("Invalid choice.Please try again");
            }
        }
        scanner.close();
    }
    private static void addStudent(Scanner scanner){
        System.out.print("Enter Student ID: ");
        int student_id=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student name: ");
        String name=scanner.nextLine();
        System.out.print("Enter Department: ");
        String department=scanner.nextLine();
        System.out.print("Enter Year:");
        int year=scanner.nextInt();
        System.out.print("Enter CGPA: ");
        double cgpa=scanner.nextDouble();

        Student student=new Student(student_id,name,department,year,cgpa);
        database.addStudent(student);
    }
    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter Student ID to update: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter New Year: ");
        int year = scanner.nextInt();
        System.out.print("Enter New CGPA: ");
        double cgpa = scanner.nextDouble();

        database.updateStudent(studentId, name, department, year, cgpa);
    }
    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        int studentId = scanner.nextInt();
        database.deleteStudent(studentId);
    }
}