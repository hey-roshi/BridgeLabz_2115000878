import java.lang.reflect.Field;
import java.util.Scanner;

public class objectToJson {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Access private fields

            try {
                // Append field name and value
                json.append("\"").append(field.getName()).append("\": \"")
                    .append(field.get(obj)).append("\"");

                // Add a comma if it's not the last field
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        // Creating a Person object with user input
        Person person = new Person(name, age);

        // Convert the Person object to JSON-like string
        String jsonString = toJson(person);
        System.out.println("JSON Representation: " + jsonString);
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}