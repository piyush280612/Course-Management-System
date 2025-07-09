use coursemanagement;

CREATE TABLE studentData (
    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    age TINYINT,
    rollnumber INT NOT NULL unique,
    gradeSemester VARCHAR(10)
);

CREATE TABLE courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) ,
    description TEXT,
    price INT
);

CREATE TABLE enrollments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_rollNumber INT,
    course_id INT,
    enrollment_date DATE,
    FOREIGN KEY (student_rollNumber) REFERENCES studentData(rollnumber),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);
