import java.util.*;
public class freqOfElements{
     public static Map<String,Integer> countFreq(List<String> arr){
         HashMap<String,Integer> hm=new HashMap<>();
         for(String words: arr){
            hm.put(words,hm.getOrDefault(words,0)+1);   
         }
         return hm;
   
     }
     public static void main(String[] args){
        List<String> words=Arrays.asList("apple", "banana", "apple", "orange");
        Map<String,Integer>result=countFreq(words);
        System.out.println(result);
    }
}     
