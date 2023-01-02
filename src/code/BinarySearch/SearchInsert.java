package code.BinarySearch;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SearchInsert
 * 类 描 述：TODO 力扣题35
 * 创建时间：2023/1/2 下午2:04
 * 创 建 人：chenweihua
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return target;
            }
        }
        return left;
    }


}
