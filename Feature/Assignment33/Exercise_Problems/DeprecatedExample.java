// Legacy API with deprecated method
class LegacyAPI {
    @Deprecated(since = "1.2", forRemoval = true)
    void oldFeature() {
        System.out.println("This is an old feature and should not be used.");
    }

    void newFeature() {
        System.out.println("This is the new recommended feature.");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        // Using @SuppressWarnings to ignore deprecation warning
        @SuppressWarnings("deprecation")
        LegacyAPI legacy = new LegacyAPI();
        legacy.oldFeature(); // Still callable, but discouraged

        api.newFeature(); // Preferred method
    }
}