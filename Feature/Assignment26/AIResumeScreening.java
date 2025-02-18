import java.util.*;

// Abstract JobRole class
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract void requiredSkills();
}

// Specific Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public void requiredSkills() {
        System.out.println("Required Skills: Java, Data Structures, Algorithms, System Design.");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public void requiredSkills() {
        System.out.println("Required Skills: Python, Machine Learning, Statistics, Big Data.");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public void requiredSkills() {
        System.out.println("Required Skills: Business Strategy, UX Design, Data Analysis.");
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private String candidateName;
    private int experienceYears;
    private T jobRole;

    public Resume(String candidateName, int experienceYears, T jobRole) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void displayResume() {
        System.out.println("\nCandidate: " + candidateName);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Applying for: " + jobRole.getRoleName());
        jobRole.requiredSkills();
    }
}

// Resume Screening System
class ResumeScreeningSystem {
    private List<Resume<? extends JobRole>> resumeQueue = new ArrayList<>();

    public void addResume(Resume<? extends JobRole> resume) {
        resumeQueue.add(resume);
    }

    public void processResumes() {
        System.out.println("\nProcessing Resumes...");
        for (Resume<? extends JobRole> resume : resumeQueue) {
            resume.displayResume();
        }
    }

    // Generic method to validate a resume
    public static <T extends JobRole> boolean isValidResume(Resume<T> resume) {
        return resume.getExperienceYears() > 0;
    }
}

// Main Class
public class AIResumeScreening {
    public static void main(String[] args) {
        // Create Job Role Instances
        SoftwareEngineer seRole = new SoftwareEngineer();
        DataScientist dsRole = new DataScientist();
        ProductManager pmRole = new ProductManager();

        // Create Resume Instances
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice Johnson", 5, seRole);
        Resume<DataScientist> resume2 = new Resume<>("Bob Smith", 3, dsRole);
        Resume<ProductManager> resume3 = new Resume<>("Charlie Brown", 8, pmRole);

        // Resume Screening System
        ResumeScreeningSystem screeningSystem = new ResumeScreeningSystem();
        screeningSystem.addResume(resume1);
        screeningSystem.addResume(resume2);
        screeningSystem.addResume(resume3);

        // Process Resumes
        screeningSystem.processResumes();

        // Validate Resumes
        System.out.println("\nResume Validation:");
        System.out.println(resume1.getCandidateName() + " Valid: " + ResumeScreeningSystem.isValidResume(resume1));
        System.out.println(resume2.getCandidateName() + " Valid: " + ResumeScreeningSystem.isValidResume(resume2));
    }
}
