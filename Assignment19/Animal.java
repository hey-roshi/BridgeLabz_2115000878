public class Animal{
   String name;
   int age;
   public Animal(String name, int age){
        this.name=name;
        this.age=age; 
   }
   public void makeSound(){
      System.out.println("this is animal");
   }
   public static void main(String args[]){
      Animal obj1=new Animal("animal1",01);
      obj1.makeSound();
      Animal obj2=new Dog("animal2",02);
      obj2.makeSound();
   }
} 
class Dog extends Animal{
   public Dog(String name,int age){
       super(name,age); 
   }
   public void makeSound(){
      System.out.println("this is dog");
   }
}
class Cat extends Animal{
   public Cat(String name, int age){
      super(name,age);
   }
   public void makeSound(){
      System.out.println("this is cat");
   }

}
class Bird extends Animal{
   public Bird(String name, int age){
     super(name,age);
   }
   public void makeSound(){
     System.out.println("this is bird");
   }
}
