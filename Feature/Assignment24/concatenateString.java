public class concatenateString{
      public static String concat(String[] words){
          StringBuffer sb=new StringBuffer();
          for(String str:words){
             sb.append(str);
          }
          return sb.toString();
      }
      public static void main(String args[]){
           String words[]={"Hello","World","Java"};
           String res=concat(words);
           System.out.println(res);
      }
}
