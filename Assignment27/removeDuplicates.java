import java.util.*;
public class removeDuplicates{
    public static List<Integer> removeDuplicates(List<Integer> list){
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
    public static void main(String[] args){
        List<Integer> numbers=new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        List<Integer> result=removeDuplicates(numbers);
        System.out.println(result);  
    }
}
