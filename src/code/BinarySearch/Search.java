package code.BinarySearch;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Search
 * 类 描 述：TODO 力扣题33 搜索旋转排序数组
 * 创建时间：2022/11/9 下午2:34
 * 创 建 人：chenweihua
 */
public class Search {


    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            //右边有序
            if (nums[mid] < nums[r]) {
                //在右半边
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                    //在左半边
                } else {
                    r = mid - 1;
                }
                //左边有序
            } else {
                //在左半边
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                    //在右半边
                } else {
                    l = mid + 1;
                }

            }
        }
        return -1;
    }


}
