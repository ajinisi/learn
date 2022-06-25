package concurrent;

/*
 学习线程的创建
 */

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


    public static void main(String[] args) {


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

        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
