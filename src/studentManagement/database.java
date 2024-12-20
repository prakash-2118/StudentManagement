package studentManagement;
import java.sql.*;
public class database {
    private static final String url="jdbc:mysql://localhost:3306/studentManagement";
    private static final String user="root";
    private static final String password="prakash@21";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void addStudent(Student student){
        String query="INSERT INTO students (student_id,name,department,year,cgpa) VALUES (?,?,?,?,?)";
        try (Connection con=getConnection();
             PreparedStatement ps=con.prepareStatement(query)){
            ps.setInt(1,student.getStudentId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getDepartment());
            ps.setInt(4,student.getYear());
            ps.setDouble(5,student.getCgpa());

            int rowsAffected=ps.executeUpdate();
            System.out.println("Rows affected : "+ rowsAffected);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void viewStudents() {
        String query = "SELECT * FROM students";
        try (Connection con = getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            System.out.println("------------------------------------------------------------");
            System.out.printf("| %-10s | %-15s | %-10s | %-4s | %-5s |\n",
                    "Student ID", "Name", "Department", "Year", "CGPA");
            System.out.println("------------------------------------------------------------");
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                int year = rs.getInt("year");
                double cgpa = rs.getDouble("cgpa");

                Student student = new Student(studentId, name, department, year, cgpa);
                student.displayStudent();
            //
            }
            System.out.println("------------------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(int student_id, String name, String department,int year, double cgpa) {
        String query = "UPDATE students SET name = ? , department = ? , year = ? , cgpa = ? WHERE student_id = ?";
        try(Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1,name);
            ps.setString(2,department);
            ps.setInt(3,year);
            ps.setDouble(4,cgpa);
            ps.setInt(5,student_id);

            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Student details updated successfully..!!!");
        } else {
                System.out.println("Student ID not found");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteStudent (int student_id){
        String query = "DELETE FROm students WHERE student_id = ?";
        try (Connection con=getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            ps.setInt(1,student_id);
            int rowsAffected=ps.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Student Deleted Successfully ..!!!");
            }
            else{
                System.out.println("Student ID not found");
            }
        }

        catch ( SQLException e){
            e.printStackTrace();
        }
    }
}
