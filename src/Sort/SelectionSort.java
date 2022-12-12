package Sort;
import java.util.Arrays;


/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SelectionSort
 * 类 描 述：TODO 选择排序 在0~n-1上寻找最小值与位置0上的数交换，在1~n-1上寻找最小值与1位置上的数交换.
 * 创建时间：2022/9/21 下午1:06
 * 创 建 人：chenweihua
 */


public class SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length ; i++) { // i ~ N-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ N-1 上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {
        int[] arr = {1,4,6,7,9,2,3};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }



//
//    // for test
//    public static void comparator(int[] arr) {
//        Arrays.sort(arr);
//    }
//
//    // for test
//    public static int[] generateRandomArray(int maxSize, int maxValue) {
//        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
//        }
//        return arr;
//    }
//
//    // for test
//    public static int[] copyArray(int[] arr) {
//        if (arr == null) {
//            return null;
//        }
//        int[] res = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            res[i] = arr[i];
//        }
//        return res;
//    }
//
//    // for test
//    public static boolean isEqual(int[] arr1, int[] arr2) {
//        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
//            return false;
//        }
//        if (arr1 == null && arr2 == null) {
//            return true;
//        }
//        if (arr1.length != arr2.length) {
//            return false;
//        }
//        for (int i = 0; i < arr1.length; i++) {
//            if (arr1[i] != arr2[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // for test
//    public static void printArray(int[] arr) {
//        if (arr == null) {
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//
//    // for test
//    public static void main(String[] args) {
//        int testTime = 500000;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            selectionSort(arr1);
//            comparator(arr2);
//            if (!isEqual(arr1, arr2)) {
//                succeed = false;
//                printArray(arr1);
//                printArray(arr2);
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//        printArray(arr);
//        selectionSort(arr);
//        printArray(arr);
//    }

}

