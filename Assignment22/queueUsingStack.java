import java.util.*;
class myQueue{
    Stack<Integer>input=new Stack<>();
    Stack<Integer>output=new Stack<>();
    /** Initialize your data structure here. */
    public myQueue() {
    }
    public void push(int x) {
        System.out.println("The element pushed is " + x);
        input.push(x);
    }
    public int pop(){
        // shift input to output 
        if(output.empty())
           while(input.empty()==false){
                output.push(input.peek());
                input.pop();
            }
        int x = output.peek();
        output.pop();
        return x;
    }
    public int peek(){
        // shift input to output 
        if(output.empty())
            while(input.empty()==false){
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }
    int size(){
        return (output.size()+input.size());
    }

}
public class queueUsingStack{
    public static void main(String args[]){
        myQueue q=new myQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());
    }
}
