import java.util.*;
class circularTourProb{
    public static void main(String[] args){
        int[] petrol={4, 6, 7, 4};
        int[] distance={6, 5, 3, 5};
        int startIndex=canCompleteCircuit(petrol, distance);
        System.out.println("Start at petrol pump index: " + startIndex);
    }
    public static int canCompleteCircuit(int[] gas,int[] cost){
        Queue<Integer> queue=new LinkedList<>();
        int n=gas.length;
        int start=0, balance=0, totalSurplus=0;
        for(int i=0;i<n;i++){
            queue.add(i);
            int surplus=gas[i]-cost[i];
            balance+=surplus;
            totalSurplus+=surplus;
            if(balance<0){
                while(!queue.isEmpty()){
                    start=queue.poll()+1;
                }
                balance=0;
            }
        }
        return (totalSurplus>=0)?start:-1;
    }
}
