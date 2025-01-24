import java.util.Scanner;

public class studentPercentage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        // Create arrays to store marks, percentages, and grades
        int[] marks = new int[3];  // Array to store marks for 3 subjects (Physics, Chemistry, Maths)
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];

        // Take input for marks of students
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            int totalMarks = 0;

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                do {
                    System.out.print(subject + " marks (0-100): ");
                    marks[j] = sc.nextInt();
                    if (marks[j] < 0 || marks[j] > 100) {
                        System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                    }
                } while (marks[j] < 0 || marks[j] > 100);
                totalMarks += marks[j];
            }

            percentages[i] = (double) totalMarks / 3;  // Calculate the percentage for the student

            // Determine grade based on percentage
            if (percentages[i] >= 80) {
                grades[i] = "Level 4, above agency normalized standards";
            } else if (percentages[i] >= 70 && percentages[i] <= 79) {
                grades[i] = "Level 3, at agency normalized standards";
            } else if (percentages[i] >= 60 && percentages[i] <= 69) {
                grades[i] = "Level 2, below but approaching agency normalized standards";
            } else if (percentages[i] >= 50 && percentages[i] <= 59) {
                grades[i] = "Level 1, well below agency normalized standards"; 
            } else if (percentages[i] >= 40 && percentages[i] <= 49) {
                grades[i] = "Level 1-, too below agency normalized standards";
            } else {
                grades[i] = "Remedial Standards";
            }
        }

        // Display the results
        System.out.println("\nResults:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + marks[0] + ", Chemistry: " + marks[1] + ", Maths: " + marks[2]);
            System.out.println("Percentage: " + percentages[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }
    }
}

