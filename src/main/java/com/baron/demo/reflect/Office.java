package com.baron.demo.reflect;

import org.aspectj.weaver.World;

/***
 @package com.baron.demo.reflect
 @author Baron
 @create 2020-09-29-6:29 PM
 */
public class Office {
    public static void main(String[] args) {
        if ("Word".equals(args[0])) {
            Word w = new Word();
            w.start();
        }
        if ("Excel".equals(args[0])) {
            Excel e = new Excel();
            e.start();
        }
    }
}
class Word {
    public static void main(String[] args) {
        System.out.println("word");
    }
    void start() {
        System.out.println("word");
    }
}
class Excel {
    public static void main(String[] args) {
        System.out.println("Excel");
    }
    void start() {
        System.out.println("excel");
    }
}

class OfficeBetter {
    public static void main(String[] args) {
        try {
            Class c = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
