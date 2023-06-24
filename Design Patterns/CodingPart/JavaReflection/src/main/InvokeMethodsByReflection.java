package main;

import java.lang.reflect.Method;

public class InvokeMethodsByReflection {
	public static void main(String[] args) {
        SampleClass sampleClass = new SampleClass("Hello", 42);

        // Invoke private methods using Reflection
        try {
            // Get the class object for the instance
            Class<?> sample = sampleClass.getClass();

            // Access the private methods
            Method getNameMethod = sample.getDeclaredMethod("getName");
            Method setInfoMethod = sample.getDeclaredMethod("setInfo", String.class, String.class, int.class);

            // Enable access to private methods
            getNameMethod.setAccessible(true);
            setInfoMethod.setAccessible(true);

            // Invoke the getName method
            String name = (String) getNameMethod.invoke(sampleClass);
            System.out.println("Current name: " + name);

            // Invoke the changeInfo method
            setInfoMethod.invoke(sampleClass, "John", "Doe", 30);

            // Invoke the getName method again to get the updated name
            name = (String) getNameMethod.invoke(sampleClass);
            System.out.println("Updated name: " + name);
            
        } catch (NoSuchMethodException | IllegalAccessException |
                java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
