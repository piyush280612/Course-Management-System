// Enrollment.java
import java.sql.Date;

public class Enrollment {
    public int id;
    public int studentRollNumber;
    public int courseId;
    public Date enrollmentDate;

    public Enrollment(int studentRollNumber, int courseId, Date enrollmentDate) {
        this.studentRollNumber = studentRollNumber;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }

    public Enrollment(int id, int studentRollNumber, int courseId, Date enrollmentDate) {
        this.id = id;
        this.studentRollNumber = studentRollNumber;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
    }
}

