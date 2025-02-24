
    public class ReflectionObjectCreation {
        public static void main(String[] args) throws Exception {
            // Create an instance dynamically without new keyword
            Class<?> cls = Class.forName("Student");
            Student student = (Student) cls.getDeclaredConstructor().newInstance();
    
            // Invoke method to verify object creation
            student.display();
        }
    }
    

