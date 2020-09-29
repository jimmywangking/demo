package com.baron.demo.reflect;

/***
 @package com.baron.demo.reflect
 @author Baron
 @create 2020-09-29-7:11 PM
 */
public class ClassDemo2 {
    public static void main(String[] args) {
//        ClassUtil.printFields("hello".getClass());
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        ClassUtil.printClassMessage("hello");
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        ClassUtil.printConstractorMsg("hello");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
        ClassUtil.printConstractorMsg(123);

    }
}
