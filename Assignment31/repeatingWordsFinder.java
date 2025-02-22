import java.util.regex.*;

public class repeatingWordsFinder {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Pattern pattern = Pattern.compile("\\b(\\w+)\\s+\\1\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
