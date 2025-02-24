//package ques1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
public class ReflectionClassInfo {
    public static void main(String[] args) throws ClassNotFoundException{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter class name");
        String className=sc.nextLine();
        Class<?>cls=Class.forName(className);
        System.out.println("class name: "+cls.getName());
        // Display constructors
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }

        // Display fields
        System.out.println("\nFields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field);
        }

        // Display methods
        System.out.println("\nMethods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}
