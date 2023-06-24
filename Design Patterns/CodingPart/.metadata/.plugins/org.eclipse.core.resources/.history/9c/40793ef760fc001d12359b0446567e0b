package main;

import java.lang.reflect.*;

public class RetrievingByReflection {
    public static void main(String[] args) {
        Class<?> sample = SampleClass.class;
        
        SampleClass sc = new SampleClass();

        // Get the class name
        System.out.println("Class name: " + sample.getName());

        // Get the constructors
        Constructor<?>[] constructors = sample.getConstructors();
        System.out.println("Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.toString());
        }

        // Get the fields
        Field[] fields = sample.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            field.setAccessible(true); // Enable access to private fields
            String fieldName = field.getName();
            Object fieldValue = null;
            try {
                fieldValue = field.get(sc);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(fieldName + " = " + fieldValue);
        }

        // Get the methods
        Method[] methods = sample.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            method.setAccessible(true); // Enable access to private methods
            System.out.println(method.getName());
        }
    }
}
