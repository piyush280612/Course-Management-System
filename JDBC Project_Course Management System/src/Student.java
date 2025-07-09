//Student.java
public class Student {
    public int id;
    public String name;
    public String email;
    public int age;
    public int rollnumber;
    public String gradeSemester;

    // ✅ Constructor for adding new students (NO id)
    public Student(String name, String email, int age, int rollnumber, String gradeSemester) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.rollnumber = rollnumber;
        this.gradeSemester = gradeSemester;
    }

    // ✅ Constructor for fetching students from DB (WITH id)
    public Student(int id, String name, String email, int age, int rollnumber, String gradeSemester) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.rollnumber = rollnumber;
        this.gradeSemester = gradeSemester;
    }
}

