package com.baron.demo.reflect;

import org.bouncycastle.asn1.cms.TimeStampAndCRL;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/***
 @package com.baron.demo.reflect
 @author Baron
 @create 2020-09-29-6:53 PM
 */
public class ClassUtil {
    public static void main(String[] args) {
        printClassMessage(System.currentTimeMillis());
    }
    public static void printClassMessage(Object obj) {
        Class c = obj.getClass();
        System.out.println(c.getName());
        System.out.println(c.getMethods());
        System.out.println(c.getDeclaredClasses());
        System.out.println(c.getDeclaredMethods());
        Method[] ms = c.getMethods();
        for (Method m : ms) {
            printMethods(m);


            printFields(c);
        }
    }

    public static void printMethods(Method m) {
        Class returnType = m.getReturnType();
        System.out.print(returnType.getName()+" ");
        System.out.print(m.getName()+ "(");
        Class[] paramTypes = m.getParameterTypes();
        for (Class paramType : paramTypes) {
            System.out.print(paramType.getTypeName()+",");

        }
        System.out.println(")");
    }

    public static void printFields(Class c) {
        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            Class fieldType = f.getType();
            String typeName = fieldType.getTypeName();
            String fieldName = f.getName();
            System.out.println(fieldName+"-"+fieldType);
        }
    }

    public static void printConstractorMsg(Object obj) {
        Class c = obj.getClass();
        Constructor[] constructors = c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName()+"(");
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class classParam : paramTypes) {
                System.out.print(classParam.getName()+",");

            }
            System.out.println(")");
        }
    }
}
