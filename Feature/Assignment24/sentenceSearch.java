import java.util.Scanner;
public class sentenceSearch{
    public static String searchSentence(String[] sentences,String word){
        for(String sentence:sentences){
            if(sentence.toLowerCase().contains(word.toLowerCase())){ 
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] sentences={"The quick brown fox jumps over the lazy dog.",
            "Java is a widely used programming language.",
            "Artificial Intelligence is shaping the future.",
            "Data structures and algorithms are essential for coding.",
            "The weather is pleasant today."};
        System.out.print("Enter the word to search: ");
        String word = sc.nextLine();
        String result = searchSentence(sentences, word);
        System.out.println("Result: " + result);
    }
}
