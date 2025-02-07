class Course{
    String courseName;
    int duration;
    public Course(String courseName, int duration){
         this.courseName=courseName;
         this.duration=duration;
    }
    public void getDetails(){
         System.out.println("the course is: "+courseName+" and the duration is: "+duration);
    }
}
class OnlineCourse extends Course{
    String platform;
    String isRecorded;
    public OnlineCourse(String courseName,int duration, String platform, String isRecorded){
        super(courseName,duration);
        this.platform=platform;
        this.isRecorded=isRecorded;
    }
    public void getDetails(){
         System.out.println("platform is: "+platform+" and is it recorded: "+isRecorded);
    }

}
class PaidOnlineCourse extends OnlineCourse{
    int fees;
    int discount;
    public PaidOnlineCourse(String courseName,int duration, String platform, String isRecorded,int fees, int discount){
           super(courseName,duration,platform,isRecorded);
           this.fees=fees;
           this.discount=discount;
    }
    public void getDetails(){
         System.out.println("the fees is: "+fees+" and the discount is: "+discount);
    }

}
public class educational{
    public static void main(String args[]){
         Course obj1=new Course("Mathematical",5);
         obj1.getDetails();
         Course obj2=new OnlineCourse("Engineering",2,"Youtube","Yes");
         obj2.getDetails();
    }
}
