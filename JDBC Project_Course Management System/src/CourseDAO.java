//CourseDAO.java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void addCourse(Course course) {
        try (Connection conn = DBconnection.getConnection()) {
            String sql = "INSERT INTO courses (title, description, price) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, course.title);
            stmt.setString(2, course.description);
            stmt.setInt(3, course.price);
            stmt.executeUpdate();
            System.out.println("✅ Course added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        try (Connection conn = DBconnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM courses");
            while (rs.next()) {
                list.add(new Course(rs.getInt("id"), rs.getString("title"),
                        rs.getString("description"), rs.getInt("price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
