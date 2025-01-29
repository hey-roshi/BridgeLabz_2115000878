import java.util.*;
public class palindromeChecker{
    public static void main(String[] args){
        String str=takeInput("Enter a string : ");
        boolean isPalindrome=checkPalindrome(str);
        displayResult(str,isPalindrome);
    }
    private static String takeInput(String prompt){
        Scanner sc=new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextLine().trim();
    }
    private static boolean checkPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private static void displayResult(String str, boolean isPalindrome){
        if(isPalindrome){
            System.out.println("'" + str + "' is a palindrome.");
        }else {
            System.out.println("'" + str + "' is not a palindrome.");
        }
    }
}

