import java.util.Arrays;

// https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
public class topK {

    static int cnt = 0;
    static int cnt1 = 0;

    public static void main(String[] args) {
        System.out.println("hello");

        int[] arr = {4,8,1,10,0,11,15,66,3};
        topK(arr,0,arr.length-1,5);

        System.out.println(Arrays.toString(arr));
        System.out.println(cnt1);
    }


    static void topK(int[] arr,int low,int high,int k) {

        int p = partition(arr,low,high);
        while (p != k-1) {
            if (p>k-1) {
                // 不要把p包含，不然会死循环
                p = partition(arr,low,p-1);
            } else {
                p = partition(arr,p+1,high);
            }
        }
        return;
    }



    // 最复杂的部分
    static int partition(int[] arr,int low,int high) {
        // 第一个位置当作p位
        int pivot = low;
        // 在后面的位置找到比p小的元素
        for (int j=low+1;j<=high;j++) {
            if (arr[low] > arr[j]) {
                // 把位置腾开
                pivot++;
                // 安置比p小的元素
                swap(arr,pivot,j);
                cnt++;
            }
        }
        // 最后把比p小的元素抛弃在p的前面
        swap(arr,pivot,low);
        cnt++;
        return pivot;
    }


    // 交换两个位置的元素
    static void swap(int[] arr,int a,int b) {
        if (a == b) {
            return;
        }
        cnt1++;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
