package code.Sort;


/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FindKthLargest
 * 类 描 述：TODO 力扣第215题 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 创建时间：2022/10/12 下午9:43
 * 创 建 人：chenweihua
 */

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 第 1 大的数，下标是 len - 1;
        // 第 2 大的数，下标是 len - 2;
        // ...
        // 第 k 大的数，下标是 len - k;
        //
        int target = n - k;

        int left = 0;
        int right = n - 1;

        int pivotIndex = partition(nums, left, right);
        while (left <= right) {
            pivotIndex = partition(nums, left, right);
            if ((pivotIndex == target)) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return nums[pivotIndex];
    }

    //返回值即是数在数组中的位置下标
    public int partition(int[] nums, int left, int right) {
        //在数组中随机找一个数作为比较值
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        //将该比较值放到数组最左端
        swap(nums, left, randomIndex);
        //存储该值
        int pivot = nums[left];
        //定义比该值小区间右端点
        int less = left + 1;
        //定义比该值大的区间左端点
        int more = right;
        //当前数与比较值进行比较
        int index = left + 1;
        while (index <= more) {
            if (nums[index] < pivot) {
                swap(nums, less++, index++);
            } else if (nums[index] > pivot) {
                swap(nums, more--, index);
            } else {
                index++;
            }
        }
        //将该比较值从数组最左端移动到数组中，左边的数都比该比较值小，右边的数都比比较值大
        swap(nums, left, --index);
        //该比较值所在的位置就是排好序后的位置
        return index;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
