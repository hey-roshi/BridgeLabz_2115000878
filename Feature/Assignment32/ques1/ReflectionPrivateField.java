
import java.lang.reflect.Field;
public class ReflectionPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> cls = person.getClass();

        // Access private field
        Field field = cls.getDeclaredField("age");
        field.setAccessible(true); // Bypass access control

        // Get and print field value
        System.out.println("Old Age: " + field.get(person));

        // Modify private field
        field.set(person, 30);
        System.out.println("New Age: " + field.get(person));
    }
}

