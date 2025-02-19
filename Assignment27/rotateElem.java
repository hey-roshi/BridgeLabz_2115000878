import java.util.*;
public class rotateElem{
    public static void rotate(List<Integer> list,int k){
        int n=list.size();
        k=k%n;
        reverse(list,0,n-1);
        reverse(list,0,k-1);
        reverse(list,k,n-1);
    }
    public static void reverse(List<Integer> list, int start, int end){
        while(start<end){
            Collections.swap(list,start,end);
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        List<Integer> numbers=new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy=2;
        rotate(numbers,rotateBy);
        System.out.println(numbers);
    }
}

