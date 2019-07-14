package company.Concurrency;

import static company.Concurrency.ThreadColor.*;

public class Threads {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread!"); // this execution is the only execution we know for sure will run first

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread() { // creating an anonymous class
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        // we can write the above as a lambda too!
        // new Thread( () -> System.out.println("Hello from another class"));

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");

    }
}

class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from another thread!");
    }
}

class ThreadColor {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m"; // anonymous thread
    public static final String ANSI_BLUE = "\u001B[34m"; // name thread
    public static final String ANSI_PURPLE = "\u001B[35m"; // main thread
    public static final String ANSI_CYAN = "\u001B[36m";
}
