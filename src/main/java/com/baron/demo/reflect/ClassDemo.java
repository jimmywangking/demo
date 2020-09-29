package com.baron.demo.reflect;

/***
 @package com.baron.demo.reflect
 @author Baron
 @create 2020-09-29-6:46 PM
 */
public class ClassDemo {
    public static void main(String[] args) {
        Class c1 = int.class;
        Class c2 = String.class;
        Class c3 = Double.class;
        Class c4 = double.class;
        Class c5 = void.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getSimpleName());
        System.out.println(c4.getTypeName());
        System.out.println(c5.getCanonicalName());
    }
}
