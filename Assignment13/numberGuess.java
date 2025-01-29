import java.util.*;
public class numberGuess{
    public static void main(String[] args){
        System.out.println("Think of a number between 1 and 100.");
        playGame();
    }
    private static void playGame(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        boolean guessedCorrectly = false;
        while (!guessedCorrectly){
            int guess = generateRandomGuess(rand, lowerLimit, upperLimit);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct'):");
            String feedback = getUserFeedback(sc);
            switch (feedback) {
                case "high":
                    upperLimit = guess - 1;
                    break;
                case "low":
                    lowerLimit = guess + 1;
                    break;
                case "correct":
                    System.out.println("Guessed correctly, Your number is " + guess + ".");
                    guessedCorrectly = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }
    }

    private static int generateRandomGuess(Random rand, int lowerLimit, int upperLimit){
        return rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
    }

    private static String getUserFeedback(Scanner sc) {
        String feedback = sc.nextLine().trim().toLowerCase();
        return feedback;
    }
}

