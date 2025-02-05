import java.util.*;
class Course {
    private String courseName;
    private List<Student> enrolledStudents;
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }
    public String getCourseName() {
        return courseName;
    }
    public void enrollStudent(Student stu) {
        if (!enrolledStudents.contains(stu)) {
            enrolledStudents.add(stu);
        }
    }
    public void showEnrolledStudents() {
        System.out.println("Enrolled students in " + courseName + ":");
        for (Student stu : enrolledStudents) {
            System.out.println(stu.getName());
        }
    }
}
class Student {
    private String name;
    private List<Course> courses;
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void enrollInCourse(Course cour) {
        if (!courses.contains(cour)) {
            courses.add(cour);
            cour.enrollStudent(this); // Maintain bidirectional relationship
        }
    }
    public void showEnrolledCourses() {
        System.out.println(name + " is enrolled in the following courses:");
        for (Course cour : courses) {
            System.out.println(cour.getCourseName());
        }
    }
}
class School {
    private String name;
    private List<Student> students;
    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    public void addStudent(Student stu) {
        if (!students.contains(stu)) {
            students.add(stu);
        }
    }
    public void showAllStudents() {
        System.out.println("Students in " + name + ":");
        for (Student stu : students) {
            System.out.println(stu.getName());
        }
    }
}
public class SchoolManagement {
    public static void main(String[] args) {
        // Create a school
        School mySchool = new School("Modern Academy International");

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        Course english = new Course("English");

        // Create students
        Student riya = new Student("Riya");
        Student rosh = new Student("Rosh");

        // Enroll students in courses
        riya.enrollInCourse(math);
        riya.enrollInCourse(science);
        rosh.enrollInCourse(science);
        rosh.enrollInCourse(english);

        // Add students to the school (aggregation relationship)
        mySchool.addStudent(riya);
        mySchool.addStudent(rosh);

        // Display information
        mySchool.showAllStudents();
        riya.showEnrolledCourses();
        rosh.showEnrolledCourses();

        math.showEnrolledStudents();
        science.showEnrolledStudents();
        english.showEnrolledStudents();
    }
}
