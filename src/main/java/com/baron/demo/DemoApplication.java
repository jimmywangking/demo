package com.baron.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    public static AtomicInteger  atom;

    public synchronized  void test1(){
        System.out.println("1");
    }
    public synchronized  void testAll(){
        test1();
    }
}
