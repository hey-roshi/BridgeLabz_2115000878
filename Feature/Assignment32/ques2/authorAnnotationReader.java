import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME) // Retain annotation at runtime
@interface Author {
    String name();
}
@Author(name = "PremChand")
class Document {
}
public class authorAnnotationReader{
    public static void main(String[] args) {
        Class<Document> clazz = Document.class;
        Author author = clazz.getAnnotation(Author.class);
        System.out.println(author != null ? "Author Name: " + author.name() : "No Author annotation found.");
    }
}
