import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder jsonString = new StringBuilder("{");
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            Map<String, String> jsonMap = new HashMap<>();

            for (Field field : fields) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    field.setAccessible(true);
                    jsonMap.put(annotation.name(), field.get(obj).toString());
                }
            }

            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                jsonString.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
            }

            // Remove last comma and space, and close the JSON object
            if (jsonString.length() > 1) {
                jsonString.setLength(jsonString.length() - 2);
            }
            jsonString.append("}");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return jsonString.toString();
    }
}

public class CustomSerialization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the User object
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        // Create User object
        User user = new User(username, email, age);

        // Serialize object to JSON
        String json = JsonSerializer.toJson(user);
        System.out.println("Serialized JSON: " + json);

        scanner.close();
    }
}