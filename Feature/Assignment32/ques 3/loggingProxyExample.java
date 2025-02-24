import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class loggingProxyExample {

    // Define an interface with a method
    interface Greeting {
        void sayHello(String name);
    }

    // Implement the interface
    static class GreetingImpl implements Greeting {
        @Override
        public void sayHello(String name) {
            System.out.println("Hello, " + name + "!");
        }
    }

    // Custom InvocationHandler for logging method calls
    static class LoggingInvocationHandler implements InvocationHandler {
        private final Object target;

        public LoggingInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // Log the method name before invoking the method
            System.out.println("Calling method: " + method.getName());

            // Invoke the actual method
            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Taking user input for the greeting message
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            // Create the actual Greeting object
            Greeting greeting = new GreetingImpl();

            // Create the proxy object
            Greeting proxyGreeting = (Greeting) Proxy.newProxyInstance(
                    Greeting.class.getClassLoader(),
                    new Class[]{Greeting.class},
                    new LoggingInvocationHandler(greeting)
            );

            // Call the method on the proxy, which will be intercepted by the handler
            proxyGreeting.sayHello(name);
        }
    }
}
