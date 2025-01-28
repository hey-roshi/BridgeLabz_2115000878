import java.util.*;
public class studentScoreCard{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        int[][] scores = generateScores(numberOfStudents);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
    }

    // a. Generate random scores for Physics, Chemistry, and Math
    public static int[][] generateScores(int numberOfStudents) {
        Random random = new Random();
        int[][] scores = new int[numberOfStudents][3]; // 3 for Physics, Chemistry, Math
        
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = random.nextInt(90) + 10; // Random 2-digit score for Physics
            scores[i][1] = random.nextInt(90) + 10; // Random 2-digit score for Chemistry
            scores[i][2] = random.nextInt(90) + 10; // Random 2-digit score for Math
        }
        return scores;
    }

    // b. Calculate total, average, and percentage for each student
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; // Total, Average, Percentage
        
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            
            results[i][0] = Math.round(total * 100.0) / 100.0;       // Total
            results[i][1] = Math.round(average * 100.0) / 100.0;     // Average
            results[i][2] = Math.round(percentage * 100.0) / 100.0;  // Percentage
        }
        return results;
    }

    // c. Display scorecard
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Student " + (i + 1) + "\t");
            System.out.print(scores[i][0] + "\t");
            System.out.print(scores[i][1] + "\t\t");
            System.out.print(scores[i][2] + "\t");
            System.out.print(results[i][0] + "\t");
            System.out.print(results[i][1] + "\t");
            System.out.print(results[i][2]);
            System.out.println();
        }
    }
}
