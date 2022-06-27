package concurrent;

/*
 学习线程的创建
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo {

    // 继承实现
    static class DemoThread extends Thread {

        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(this.getName() + "THR轮次" + i);
            }
        }

    }


    // 接口实现
    static class RunTarget implements Runnable {

        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "RUN轮次" + i);
            }
        }
    }



    static class ReturnableTask implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            Thread.sleep(5000);
            System.out.println("callable");
            return 100L;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        Thread thread = null;

        // 一个空线程
        thread = new Thread();
        System.out.println("线程名称" + thread.getName());
        System.out.println("线程ID" + thread.getId());
        System.out.println("线程状态" + thread.getState());
        thread.start();

        // 两个自定义线程
        for (int i = 0; i < 2; i++) {
            thread = new DemoThread();
            thread.start();
        }

        // 两个自定义线程
        for (int i = 0; i < 2; i++) {
            Runnable runnable = new RunTarget();
            thread = new Thread(runnable);
            thread.start();
        }

        // 两个匿名实例
        for (int i = 0; i < 2; i++) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + "匿名轮次" + i);
                    }
                }
            });
            thread.start();
        }

        // 两个Lambda表达式
        for (int i = 0; i < 2; i++) {
            thread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(Thread.currentThread().getName() + "Lambda轮次" + j);
                }
            });
            thread.start();
        }



        // Callable返回异步结果
        ReturnableTask returnableTask = new ReturnableTask();
        FutureTask<Long> futureTask = new FutureTask<Long>(returnableTask);
        thread = new Thread(futureTask);
        thread.start();
        // 这是一个阻塞方法
        System.out.println("异步结果" + futureTask.get());



        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
