import java.lang.reflect.Field;
import java.util.Map;
import java.util.Scanner;

public class objectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            for (var entry : properties.entrySet()) {
                Field field = getDeclaredField(clazz, entry.getKey());
                if (field != null) {
                    field.setAccessible(true);
                    field.set(obj, entry.getValue());
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping properties to object", e);
        }
    }

    private static Field getDeclaredField(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collecting user input
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        // Storing the user input in a map
        Map<String, Object> properties = Map.of(
                "name", name,
                "age", age
        );

        // Creating an object using the ObjectMapper
        Person person = toObject(Person.class, properties);
        System.out.println(person);
    }

    static class Person {
        private String name;
        private int age;

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + '}';
        }
    }
}
