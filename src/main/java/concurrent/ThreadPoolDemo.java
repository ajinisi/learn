package concurrent;

import java.util.concurrent.*;

public class ThreadPoolDemo {



    static class RunTarget implements Runnable {

        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "RUN轮次" + i);
            }
        }
    }


    public static void main(String[] args) {

        // 单线程化线程池
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        // 单线程化线程池
//        ExecutorService pool = Executors.newFixedThreadPool(3);
        //
//        ExecutorService pool = Executors.newCachedThreadPool();
        // 标准创建方式
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                // 最大线程如何设置？
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );


        for (int i = 0; i < 100; i++) {
            pool.execute(new RunTarget());
            pool.submit(new RunTarget());
        }
        pool.shutdown();

    }


}
