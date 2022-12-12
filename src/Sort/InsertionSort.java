package Sort;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：InsertionSort
 * 类 描 述：TODO 插入排序 0~0上有序 0~1上有序 0~2上有序 直到0~i上有序
 * 创建时间：2022/9/20 上午11:04
 * 创 建 人：chenweihua
 */
public class InsertionSort {

    public static void insertionSort(int[] arr){
        if(arr == null||arr.length<2){
            return;
        }
        //0~i 想有序 控制0~i遍历
        for (int i = 1; i < arr.length; i++) {
            //例如当i=2时 比较位置2和1上数的大小，在比较位置1和0上的数，将0~2上的数排序好
            for(int j = i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(j,j+1,arr);
            }
        }
    }

    public static void swap(int i, int j,int[] arr){
//        int temp = arr[j];
//        arr[j] = arr[i];
//        arr[i] = temp;

        //在不另外占用内存的情况下，利用异或的性质完成两个数的交换
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[j]^arr[i];
        arr[j] = arr[i]^arr[j];


    }

    public static void main(String[] args) {
        int[] arr = {1,4,6,9,7,2};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
