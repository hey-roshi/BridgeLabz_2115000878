class Book{
   String title;
   int publicationYear;
   public Book(String title, int publicationYear){
      this.title=title;
      this.publicationYear=publicationYear;
   }
   public void displayInfo(){
      System.out.println("Book title is: "+title);
      System.out.println("Book's publication year is: "+publicationYear);
   }     
}
class Author extends Book{
   String name;
   String bio;
   public Author(String title, int publicationYear,String name, String bio){
      super(title,publicationYear);
      this.name=name;
      this.bio=bio;
   }
    public void displayInfo(){
      System.out.println("Book title is: "+title);
      System.out.println("Book's publication year is: "+publicationYear);
      System.out.println("Book's name is: "+name);
      System.out.println("Book's bio is: "+bio);
   }
}
class LibraryMagt{
   public static void main(String args[]){
      Book obj1=new Book("Robert's Grave", 2003);
      obj1.displayInfo();
      Book obj2=new Author("Amber's Heist",2000, "Amber","related money");
      obj2.displayInfo();
   
   }
}
