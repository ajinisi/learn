package concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {


    static class SumTask extends RecursiveTask<Integer> {

        private static final int THRESHOLD = 2;
        private Integer start;
        private Integer end;

        public SumTask(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;

            if (end - start <= THRESHOLD) {

                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {

                int m = (start + end) / 2;

                SumTask sumTask1 = new SumTask(start,m);
                SumTask sumTask2 = new SumTask(m+1,end);
                sumTask1.fork();
                sumTask2.fork();
                sum = sumTask1.join() + sumTask2.join();

            }

            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumTask sumTask = new SumTask(1,100);
        Future<Integer> future = forkJoinPool.submit(sumTask);
        int sum = future.get();
        System.out.println(sum);

    }



}
