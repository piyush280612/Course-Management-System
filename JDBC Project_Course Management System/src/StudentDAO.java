//StudentDAO.java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static void addStudent(Student student) {
        try (Connection conn = DBconnection.getConnection()) {
            String sql = "INSERT INTO studentData (name, email, age, rollnumber, gradeSemester) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //  fix here
            stmt.setString(1, student.name);
            stmt.setString(2, student.email);
            stmt.setInt(3, student.age);
            stmt.setInt(4, student.rollnumber);
            stmt.setString(5, student.gradeSemester);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    student.id = rs.getInt(1); // ✅ assign ID to object
                }
            }
            System.out.println("✅ Student details added with ID: " + student.id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DBconnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM studentData");
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age"),
                        rs.getInt("rollnumber"),
                        rs.getString("gradeSemester")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
