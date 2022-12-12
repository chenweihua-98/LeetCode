package Sort;



/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MergeSort
 * 类 描 述：TODO 归并排序 时间复杂度O(N*logN) ，空间复杂度O(N)将一个数组不断分成两段，排序好后，设计两个指针，指在两段上，比较大小，根据大小放入数组
 * 创建时间：2022/9/23 上午11:47
 * 创 建 人：chenweihua
 */
public class MergeSort {


    public static void mergeSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        process(arr,0,arr.length-1);
    }


    //利用递归和2分的思想
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);//右移一位即除以2,位运算在计算机中很快
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);


    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        //三个指针分别指向两段及数组help
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            //比较两段指针所指位置数的大小，将小的存入help,同时指针向后移一位
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L+j] = help[j];
        }
    }


    public static void main(String[] args) {

        int[] num = {1,7,9,10,5,6,2,1};


        for (int i = 0; i < num.length; i++) {
            mergeSort(num);
            System.out.println(num[i]);
        }


    }


}
