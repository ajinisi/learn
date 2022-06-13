package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class call {

    public static void main(String[] args) {

    //    new Thread().start();
        MyThread thread = new MyThread();
        FutureTask futureTask = new FutureTask(thread);
        new Thread(futureTask,"A").start();

    }

}

class MyThread implements Callable<String> {

    public String call() {
        System.out.println("hello");
        return "hello";
    }
}
