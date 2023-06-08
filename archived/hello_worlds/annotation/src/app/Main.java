package app;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Clazz object = new Clazz();
        Method[] methods = Clazz.class.getMethods();

        for (Method method : methods) {

            Annotation ourAnnotation = method.getAnnotation(Annotation.class);
            if (ourAnnotation != null) {
                try {
                    System.out.println(ourAnnotation.annotationParam());
                    method.invoke(object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}