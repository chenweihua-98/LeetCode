package code.Sort;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：RemoveElement
 * 类 描 述：TODO 力扣27 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 创建时间：2022/10/5 下午2:43
 * 创 建 人：chenweihua
 */
public class RemoveElement {


    public static int removeElement(int[] arr, int val) {
        int j = arr.length - 1;
        for (int i = 0; i < j; i++) {
            if (arr[i]==val){
                //注意该处i--,保证从数组后面换过来的数仍进行一次比较，而不会漏掉，最后=val的数都被放在数组最后面。j代表的是数组中与val不相等的数的个数。
                swap(arr,i--,j--);
            }
        }
        return j + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }


}
