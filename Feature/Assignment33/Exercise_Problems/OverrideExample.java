// Parent class
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Child class with @Override annotation
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark! Bark!");
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Using polymorphism
        animal.makeSound(); // Calls overridden method in Dog
    }
}