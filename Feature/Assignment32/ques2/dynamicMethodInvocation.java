import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class dynamicMethodInvocation {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MathOperations mathOperations = new MathOperations();
            Class<?> clazz = mathOperations.getClass();

            System.out.print("Enter operation (add, subtract, multiply): ");
            String operation = scanner.nextLine().toLowerCase();

            if (!operation.matches("add|subtract|multiply")) {
                System.out.println("Invalid operation.");
                return;
            }

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            Method method = clazz.getMethod(operation, int.class, int.class);
            int result = (int) method.invoke(mathOperations, num1, num2);

            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
