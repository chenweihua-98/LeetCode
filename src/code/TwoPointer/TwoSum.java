package code.TwoPointer;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：TwoSum
 * 类 描 述：TODO 力扣题167 两数之和 II - 输入有序数组
 * 创建时间：2022/11/13 下午2:41
 * 创 建 人：chenweihua
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int l= 0,r = numbers.length - 1;
        while (l < r) {
            int m = (l+ r) >> 1;//位运算更高效 /2右移一位
            if (numbers[l] + numbers[m] > target) {
                r = m - 1;
            } else if (numbers[m] + numbers[r] < target) {
                l= m + 1;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
