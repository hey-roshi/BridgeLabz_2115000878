public class Person {
    private String name;
    private int age;

    // Default Constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy Constructor (Cloning another Person object)
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display Person details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Creating an original Person object
        Person person1 = new Person("Alice", 25);
        System.out.println("Original Person:");
        person1.displayDetails();

        // Creating a cloned Person using Copy Constructor
        Person person2 = new Person(person1);
        System.out.println("\nCloned Person:");
        person2.displayDetails();
    }
}
