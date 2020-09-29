package com.baron.demo.reflect;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import sun.misc.PostVMInitHook;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/***
 @package com.baron.demo.reflect
 @author Baron
 @create 2020-09-29-7:25 PM
 */
public class MethodDemo1 {
    public static void main(String[] args) {

        A a1 = new A();
        Class c = a1.getClass();

        try {
            Method m = c.getDeclaredMethod("print",new Class[]{int.class, int.class});
            Object o = m.invoke(a1,new Object[]{1,2});
            System.out.println("+++++++++++++++++++========================++++++++++++++++++++");
            Method m1 = c.getDeclaredMethod("print",new Class[]{String.class, String.class});
            Object o1 = m1.invoke(a1, new String[]{"hAppY","BirTHDAY"});
            System.out.println("+++++++++++++++++++========================++++++++++++++++++++");
            Method m2 = c.getDeclaredMethod("print",new Class[]{});
            Object o2 = m2.invoke(a1,null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class A {
    public void print(int a, int b) {
        System.out.println(a+b);
    }
    public void print (String a, String b) {
        System.out.println(a.toUpperCase()+b.toLowerCase());
    }
    public void print () {
        System.out.println("no parameter this time!");
    }
}
