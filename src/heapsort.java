import java.util.Arrays;
import java.util.PriorityQueue;

public class heapsort {



    public static void main(String[] args) {
        System.out.println("hello");

        int[] arr = {4,8,1,10,0,11,15,66,3};

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0;i<=arr.length-1;i++) {
            q.offer(arr[i]);
        }
        for (int i = 0;i<=arr.length-1;i++) {
            arr[i] = q.poll();
        }

        System.out.println(Arrays.toString(arr));
    }




}
