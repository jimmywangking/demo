package com.baron.demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/***
 @package com.baron.demo.reflect
 @author Baron
 @create 2020-09-29-7:44 PM
 */
public class PatternDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello world!");

        Class c = list.getClass();
        Class c1 = list1.getClass();


        Method m = null;
        try {
            m = c1.getMethod("add", Object.class);
            m.invoke(list1, 20);
            System.out.println(list1.size());
            System.out.println(list1);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
