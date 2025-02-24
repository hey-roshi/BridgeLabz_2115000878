import java.lang.reflect.Field;
public class configuration {
    private static String API_KEY = "initial-api-key";

    public static void main(String[] args) {
        try {
            Field apiKeyField = configuration.class.getDeclaredField("API_KEY");
            apiKeyField.setAccessible(true);
            apiKeyField.set(null, "new-api-key");
            System.out.println("Modified API_KEY: " + API_KEY);
        } 
		catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
