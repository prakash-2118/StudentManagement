package studentManagement;

public class Student {
    private int studentId;
    private String name;
    private String department;
    private int year;
    private double cgpa;

// this is constructor below
    public Student (int studentId, String name, String department,int year, double cgpa){
        this.studentId=studentId;
        this.name=name;
        this.department=department;
        this.year=year;
        this.cgpa=cgpa;
    }

    // below are getters and setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
    public void displayStudent(){
        System.out.printf("| %-10d | %-15s | %-10s | %-4d | %-5.2f |\n",
                studentId, name, department, year, cgpa);
    }
}
