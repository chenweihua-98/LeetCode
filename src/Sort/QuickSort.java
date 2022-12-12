package Sort;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：QuickSort
 * 类 描 述：TODO 快速排序 时间复杂度O(N*logN)
 * 创建时间：2022/9/25 下午9:04
 * 创 建 人：chenweihua
 */
public class QuickSort {


//    public static void quickSort(int[] arr) {
//        if (arr == null || arr.length < 2) {
//            return;
//        }
//        quickSort(arr, 0, arr.length - 1);
//    }

    //arr[l..r]排好序 利用递归
    public  void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }


    // 这是一个处理arr[l..r]的函数
    // 默认以arr[r]做划分，arr[r] -> p     <p   ==p   >p
    // 返回等于区域(左边界，右边界), 所以返回一个长度为2的数组res, res[0] res[1]
    public  int[] partition(int[] arr, int l, int r) {
        int less = l - 1;//<区域右边界
        int more = r;//>区域左边界
        //l 表示当前指向位置
        while (l < more) {
            //以数组最后一个数作为划分数，参考荷兰三色旗问题
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }



}
