public class stringPerformanceComparison{
    static final int N=1_000_000; 
    public static void testString(){
        long start=System.nanoTime();
        String str="";
        for(int i=0;i<N;i++){
            str+="a"; 
        }
        long end=System.nanoTime();
        System.out.println("String Time: "+(end-start)/1_000_000+" ms");
    }
    public static void testStringBuilder(){
        long start=System.nanoTime();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append("a"); 
        }
        long end=System.nanoTime();
        System.out.println("StringBuilder Time: "+(end-start)/1_000_000+" ms");
    }
    public static void testStringBuffer(){
        long start=System.nanoTime();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<N;i++){
            sb.append("a"); 
        }
        long end=System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1_000_000 + " ms");
    }
    public static void main(String[] args){
        System.out.println("Performance Comparison (Concatenating " + N + " Strings):");
        testString();
        testStringBuilder();
        testStringBuffer();
    }
}
