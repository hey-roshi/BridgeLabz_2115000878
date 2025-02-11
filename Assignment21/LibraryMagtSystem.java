import java.util.Scanner;

class BookNode {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    BookNode next, prev;

    public BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class Library {
    private BookNode head, tail;
    private int count = 0;

    public void addBook(int bookId, String title, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }

    public void removeBook(int bookId) {
        BookNode temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) return;

        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        count--;
    }

    public BookNode searchBook(String query) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void updateAvailability(int bookId, boolean status) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayBooksForward() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.isAvailable ? "Available" : "Checked Out"));
            temp = temp.next;
        }
    }

    public void displayBooksReverse() {
        BookNode temp = tail;
        while (temp != null) {
            System.out.println(temp.bookId + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.isAvailable ? "Available" : "Checked Out"));
            temp = temp.prev;
        }
    }

    public int getTotalBooks() {
        return count;
    }
}

public class LibraryMagtSystem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(101, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", true);
        library.addBook(102, "1984", "George Orwell", "Dystopian", true);
        library.addBook(103, "To Kill a Mockingbird", "Harper Lee", "Classic", false);

        System.out.println("Library Collection:");
        library.displayBooksForward();
        
        System.out.println("\nTotal Books: " + library.getTotalBooks());
        
        System.out.println("\nUpdating Availability of Book ID 103...");
        library.updateAvailability(103, true);
        library.displayBooksForward();
        
        System.out.println("\nRemoving Book ID 102...");
        library.removeBook(102);
        library.displayBooksForward();
        
        System.out.println("\nBooks in Reverse Order:");
        library.displayBooksReverse();
        
        scanner.close();
    }
}
