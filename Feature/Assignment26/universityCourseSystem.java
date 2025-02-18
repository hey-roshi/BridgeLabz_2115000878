import java.util.*;

// Abstract Course Type Class
abstract class CourseType {
    private String typeName;

    public CourseType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public abstract void evaluationMethod();
}

// Specific Course Types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based Course");
    }

    @Override
    public void evaluationMethod() {
        System.out.println("Evaluation: Written Exams and Quizzes.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based Course");
    }

    @Override
    public void evaluationMethod() {
        System.out.println("Evaluation: Assignments and Continuous Assessments.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based Course");
    }

    @Override
    public void evaluationMethod() {
        System.out.println("Evaluation: Research Papers and Thesis Submission.");
    }
}

// Generic Course Class
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayCourseDetails() {
        System.out.println(courseName + " - " + courseType.getTypeName());
        courseType.evaluationMethod();
    }
}

// Course Management System
class CourseManager {
    private List<Course<? extends CourseType>> courseList = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courseList.add(course);
    }

    public void displayAllCourses() {
        System.out.println("\nUniversity Course Catalog:");
        for (Course<? extends CourseType> course : courseList) {
            course.displayCourseDetails();
        }
    }
}

// Main Class
public class universityCourseSystem{
    public static void main(String[] args) {
        // Create Course Type Instances
        ExamCourse examType = new ExamCourse();
        AssignmentCourse assignmentType = new AssignmentCourse();
        ResearchCourse researchType = new ResearchCourse();

        // Create Courses
        Course<ExamCourse> math101 = new Course<>("Math 101", examType);
        Course<AssignmentCourse> csProject = new Course<>("Computer Science Project", assignmentType);
        Course<ResearchCourse> thesisResearch = new Course<>("Thesis Research", researchType);

        // Manage Courses
        CourseManager manager = new CourseManager();
        manager.addCourse(math101);
        manager.addCourse(csProject);
        manager.addCourse(thesisResearch);

        // Display Courses
        manager.displayAllCourses();
    }
}
