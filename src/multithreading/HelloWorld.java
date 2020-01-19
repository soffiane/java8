package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Single thread application
 */
public class HelloWorld {

    private static void sayHelloToMultipleUsers(List<String> users){
        HelloWorld helloWorld = new HelloWorld();
        /* single execution - one unique thread*/
        users.forEach(HelloWorld::sayHello);
        /**
         * main 1 Hello, FooUser
         * main 1 Hello, BarUser
         * main 1 Hello, FooBarUser
         */
        /* parallel execution - 1 thread by call*/
        users.forEach( user -> {
            Thread thread = new Thread(() -> helloWorld.sayHello(user),user );
            thread.start();
        });
        /**
         * FooUser 11 Hello, FooUser
         * BarUser 12 Hello, BarUser
         * FooBarUser 13 Hello, FooBarUser
         */
    }

    private static void sayHello(String user) {
        System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getId()+" Hello, "+user);
    }

    public static void main(String[] args){
        List<String> users = new ArrayList<>();
        users.add("FooUser");
        users.add("BarUser");
        users.add("FooBarUser");
        sayHelloToMultipleUsers(users);
    }
}
