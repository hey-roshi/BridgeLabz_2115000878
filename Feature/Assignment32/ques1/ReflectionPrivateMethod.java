
import java.lang.reflect.Method;

public class ReflectionPrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Class<?> cls = calc.getClass();

        // Access private method
        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true); // Bypass access control

        // Invoke method dynamically
        int result = (int) method.invoke(calc, 5, 10);
        System.out.println("Multiplication Result: " + result);
    }
}


