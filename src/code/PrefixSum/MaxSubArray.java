package code.PrefixSum;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MaxSubArray
 * 类 描 述：TODO 力扣题53
 * 创建时间：2022/12/4 下午2:05
 * 创 建 人：chenweihua
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = nums[0], previous = nums[0];
        for (int i = 1; i < nums.length; i++) {
            previous = Math.max(previous + nums[i], nums[i]);
            res = Math.max(previous, res);
        }
        return res;
    }
}
