import java.util.Arrays;

public class quicksort {

    static int cnt = 0;
    // 执行交换的次数
    static int swapCnt = 0;
    // 执行比较的次数
    static int compCnt = 0;

    public static void main(String[] args) {
        System.out.println("hello");


        int[] arr = {4,8,1,10,0,11,15,66,3};
        // 最坏情况 n*(n-1)/2
//        int[] arr = {9,8,7,6,5,4,3,2,1};

        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
        System.out.println(compCnt);
    }


    static void quickSort(int[] arr,int low,int high) {

        if (low<high) {
            int p = partition(arr,low,high);
            quickSort(arr,low,p-1);
            quickSort(arr,p+1,high);
        }

    }

    // 最复杂的部分
    static int partition(int[] arr,int low,int high) {
        // 第一个位置当作p位
        int pivot = low;
        // 在后面的位置找到比p小的元素
        for (int j=low+1;j<=high;j++) {
            compCnt++;
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


    static int anotherPartition(int[] arr,int low,int high) {
        //
        int pivot = low;
        while (low<high) {
            while (low<high && arr[high] >= arr[pivot]) {
                high--;
            }
            swap(arr,low,high);
            cnt++;
            while (low<high && arr[low] <= arr[pivot]) {
                low++;
            }
            swap(arr,low,high);
            cnt++;

        }
        return low;
    }


    // 交换两个位置的元素
    static void swap(int[] arr,int a,int b) {
        if (a == b) {
            return;
        }
        swapCnt++;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
