import java.util.*;
public class StockSpan{
    public static ArrayList<Integer> calculateSpan(ArrayList<Integer> arr){
        int n = arr.size(); 
        ArrayList<Integer> span = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           span.add(0);
        }
        Stack<Integer> st=new Stack<>();  
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr.get(st.peek())<=arr.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                span.set(i,(i+1));
            }else{
                span.set(i,(i-st.peek()));
            }
            st.push(i);
        }
        return span;
    }
    public static void main(String[] args){
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(10, 4, 5, 90, 120, 80));
        ArrayList<Integer> span=calculateSpan(arr);
        for(int x:span){
            System.out.print(x + " ");
        }
    }
}
