public class Fibonacci {


    public static void main(String[] args) {

        // {0，1，1，2，3，5，8} 下标从0开始

        int n = 2;

        int i = 0;
        int j = 1;

//        while (n-- != 0) {
//            j = i+j;
//            i = j-i;
//        }

        int k;
        while (n-- != 0) {
            k = i+j;
            i = j;
            j = k;
        }


        System.out.println(i);

    }
}
