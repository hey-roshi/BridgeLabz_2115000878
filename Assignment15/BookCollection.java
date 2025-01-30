public class BookCollection{
    public static void main(String args[]){
      Book obj=new Book("Anthony's Show","Anthony",450);
      obj.displayDetails();  
   }
}
class Book{
    String title;
    String author;
    int price;
    public Book(String title, String author, int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }
    public void displayDetails(){
        System.out.println("Book name is "+title);
        System.out.println("Book's author is "+author);
        System.out.println("Book's price is "+price);
    }
}

