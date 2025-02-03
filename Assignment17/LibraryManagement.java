import java.util.Scanner;
class Book{
    static String libraryName = "Central Library";
    final String isbn;
    String title;
    String author;
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    void displayDetails() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        Book book = new Book(title, author, isbn);
        if(book instanceof Book){
           Book.displayLibraryName();
           book.displayDetails();
        }else{
           System.out.println("not instance");
        }
        
    }
}
