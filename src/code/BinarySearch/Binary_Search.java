package code.BinarySearch;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Binary_Search
 * 类 描 述：TODO 二分查找模板 参考网址：https://labuladong.github.io/algo/2/20/29/
 * 创建时间：2022/11/9 上午11:16
 * 创 建 人：chenweihua
 */
public class Binary_Search {

    //找目标值模板
    int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }
    //找左边界模板
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }
    //找右边界模板
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 此时 left - 1 索引越界
        if (left - 1 < 0) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
    }
}
