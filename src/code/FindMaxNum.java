package code;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FindMaxNum
 * 类 描 述：TODO 找到数组中最大的数并返回
 * 创建时间：2022/9/22 下午2:16
 * 创 建 人：chenweihua
 */
public class FindMaxNum {


    //利用二分查找 递归的思想
    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        return getMaxNum(arr, 0, arr.length - 1);
    }

    private static int getMaxNum(int[] arr, int L, int R) {

        if (L == R) {
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);//等价于 mid = L + (R-L)/2
        int leftMax = getMaxNum(arr, L, mid);
        int rightMax = getMaxNum(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);

    }


}
