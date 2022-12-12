package code;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：NetherlandsFlag
 * 类 描 述：TODO 荷兰三色国旗问题 即将一个数组分成三块
 * 创建时间：2022/9/24 下午7:39
 * 创 建 人：chenweihua
 */
public class NetherlandsFlag {
    // 荷兰国旗问题,以数p为比较值，比p小的放在左边,比p大的放在右边,中间是等于p
    public static int[] partition(int[] arr, int L, int R, int p) {
        int less = L - 1; // <区的右边界
        int more = R + 1; // >区的左边界
        int index = L;//指针
        /**
         * 对整个数组进行遍历，指针index指向的数，与选定值比较，
         * 如果比选定值小，将index指向的数与<区右边界右边的第一个数进行交换 ，同时指针index往后移动一位，<区右边界向右移动一位
         * 如果比选定值大，将index指向的数与>区左边界左边的第一个数进行交换，index不动，>区左边界向左移动一位
         * 如果和选定数相等，index往后移动一位
        */
        while (index < more) { // index是当前数的下标
            if (arr[index] < p) {
                swap(arr, ++less, index++);
            } else if (arr[index] > p) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }
        //返回的值是等于区域的左边界以及右边界,若没有等于区域，则返回的数组前一个数会大于后一个数
        return new int[] { less + 1, more - 1 };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num = {1,4,6,7,9,2};
        for (int i = 0; i < 2; i++) {
            System.out.println(partition(num,0,num.length-1,6)[i]);
        }

    }

}
