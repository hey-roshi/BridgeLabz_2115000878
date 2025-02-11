import java.util.Scanner;

class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head, tail;

    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void removeMovie(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie removed successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }

    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " (" + temp.year + ") - Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found for this director.");
    }

    public void searchByRating(double minRating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating >= minRating) {
                System.out.println(temp.title + " (" + temp.year + ") - Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with this rating or higher.");
    }

    public void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }

    public void displayForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieMagtSystem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();

        movieList.addMovieAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addMovieAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.6);
        
        System.out.println("Movies List (Forward Order):");
        movieList.displayForward();
        
        System.out.println("\nUpdating Rating for 'Inception'...");
        movieList.updateRating("Inception", 9.0);
        movieList.displayForward();
        
        System.out.println("\nSearching Movies by Director 'Christopher Nolan':");
        movieList.searchByDirector("Christopher Nolan");
        
        System.out.println("\nRemoving 'The Dark Knight'...");
        movieList.removeMovie("The Dark Knight");
        movieList.displayForward();
    }
}
