import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    public static void enrollStudent(int rollNumber, int courseId) {
        try (Connection conn = DBconnection.getConnection()) {
            String sql = "INSERT INTO enrollments (student_rollNumber, course_id, enrollment_date) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rollNumber);
            stmt.setInt(2, courseId);
            stmt.setDate(3, new Date(System.currentTimeMillis())); // current date

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student enrolled successfully!");
            } else {
                System.out.println("⚠️ Enrollment failed!");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("❌ Enrollment failed: Invalid roll number or course ID.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Enrollment> getAllEnrollments() {
        List<Enrollment> list = new ArrayList<>();

        try (Connection conn = DBconnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM enrollments");

            while (rs.next()) {
                list.add(new Enrollment(
                        rs.getInt("id"),
                        rs.getInt("student_rollNumber"),
                        rs.getInt("course_id"),
                        rs.getDate("enrollment_date")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

