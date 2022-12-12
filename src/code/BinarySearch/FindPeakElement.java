package code.BinarySearch;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FindPeakElement
 * 类 描 述：TODO 力扣题162 寻找峰值 注意思路
 * 创建时间：2022/11/9 下午8:44
 * 创 建 人：chenweihua
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
