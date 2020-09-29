package com.baron.demo.reflect;

/***
 @package com.baron.demo
 @author Baron
 @create 2020-09-27-8:44 PM
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Foo foo1 = new Foo();
        Class c1 = Foo.class;
        Class c2 = foo1.getClass();
        Class c3 = null;
        try {
            c3 = Class.forName("com.baron.demo.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c1==c2);
        System.out.println(c1==c3);

        try {
            Foo foo = (Foo) c1.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Foo{
    void print(){
        System.out.println("FooPrint");
    }
}
