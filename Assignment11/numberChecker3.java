public class numberChecker3{
    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    // Method to store the digits of the number in a digits array
    public static int[] getDigitsArray(int number) {
        String numberStr = String.valueOf(number);
        int[] digits = new int[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }
        return digits;
    }

    // Method to reverse the digits array
    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays and check if they are equal
    public static boolean areArraysEqual(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    // Method to check if a number is a palindrome using the digits array
    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversedDigits = reverseDigitsArray(digits);
        return areArraysEqual(digits, reversedDigits);
    }

    // Method to check if a number is a duck number using the digits array
    public static boolean isDuckNumber(int number) {
        int[] digits = getDigitsArray(number);
        for (int digit : digits) {
            if (digit == 0) {
                return true; // Duck number contains a zero
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 1221;
        int number2 = 10234;

        System.out.println("Count of digits: " + countDigits(number));

        int[] digitsArray = getDigitsArray(number);
        System.out.print("Digits array: ");
        for (int digit : digitsArray) {
            System.out.print(digit + " ");
        }
        System.out.println();

        int[] reversedArray = reverseDigitsArray(digitsArray);
        System.out.print("Reversed digits array: ");
        for (int digit : reversedArray) {
            System.out.print(digit + " ");
        }
        System.out.println();

        boolean arraysEqual = areArraysEqual(digitsArray, reversedArray);
        System.out.println("Are digits array and reversed array equal? " + arraysEqual);
        System.out.println("Is " + number + " a palindrome? " + isPalindrome(number));
        System.out.println("Is " + number + " a duck number? " + isDuckNumber(number));
        System.out.println("Is " + number2 + " a duck number? " + isDuckNumber(number2));
    }
}
