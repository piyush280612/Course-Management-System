//Main.java
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentDAO studentDAO = new StudentDAO();
    static CourseDAO courseDAO = new CourseDAO();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Smart Course Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. View All Enrollments");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> addCourse();
                case 4 -> viewCourses();
                case 5 -> enrollStudentInCourse();
                case 6 -> viewAllEnrollments();
                case 0 -> System.out.println("👋 Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); // flush leftover newline

        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine(); // flush again

        System.out.print("Enter Grade/Semester: ");
        String gradeSemester = sc.nextLine();

        Student student = new Student(name, email, age, rollNumber, gradeSemester);
        StudentDAO.addStudent(student);

    }

    static void viewStudents() {
        List<Student> list = studentDAO.getAllStudents();
        for (Student s : list) {
            System.out.println("ID: " + s.id + ", Name: " + s.name + ", Email: " + s.email + ", Age: " + s.age +
                    ", Roll Number: " + s.rollnumber + ", Grade/Semester: " + s.gradeSemester);
        }
    }

    static void addCourse() {
        System.out.print("Enter course title: ");
        String title = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter Price: ");
        int priceOfCourse = sc.nextInt();

        Course course = new Course(0, title, desc, priceOfCourse);
        courseDAO.addCourse(course);
    }

    static void viewCourses() {
        List<Course> list = courseDAO.getAllCourses();
        for (Course c : list) {
            System.out.println("ID: " + c.id + ", Title: " + c.title + ", Description: " + c.description + ", Price of Course: " + c.price);
        }
    }
    static void enrollStudentInCourse() {
        System.out.print("Enter Student Roll Number: ");
        int rollNumber = sc.nextInt();
        System.out.print("Enter Course ID: ");
        int courseId = sc.nextInt();
        EnrollmentDAO.enrollStudent(rollNumber, courseId);
    }

    static void viewAllEnrollments() {
        List<Enrollment> list = EnrollmentDAO.getAllEnrollments();
        for (Enrollment e : list) {
            System.out.println("Enrollment ID: " + e.id + ", Student Roll No: " + e.studentRollNumber +
                    ", Course ID: " + e.courseId + ", Date: " + e.enrollmentDate);
        }
    }

}
