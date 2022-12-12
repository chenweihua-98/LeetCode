package code;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SmallSum
 * 类 描 述：TODO 找数组的小和 数组中每个位置左边存在着比该位置数小的数的累加 如[1,3,5,2] 1+1+3+1 = 6
 * 创建时间：2022/9/23 下午3:48
 * 创 建 人：chenweihua
 */
public class SmallSum {

    //整体思路上参考归并排序

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求小和
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int L, int m, int r) {
        int[] help = new int[r - L + 1];
        int i = 0;
        int p1 = L;//左边指针
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            //因为左边比右边的数小，则右边剩下的数都会比此时左边的数大，计算个数*左边该数的值
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            //比归并排序少了个= 也就是左右相等 先把右边的放到help数组中
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,2,2,2,3}; //1+4+4+9
        System.out.println(smallSum(arr));

    }
}
