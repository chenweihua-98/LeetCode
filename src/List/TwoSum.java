package List;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：twoSum
 * 类 描 述：TODO 力扣题167两数之和 从数组中找出满足相加之和等于目标数 target 的两个数
 * 创建时间：2022/11/6 下午8:48
 * 创 建 人：chenweihua
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{++left,++right};
            }else if(sum<target){
                ++left;
            }else{
                --right;
            }
        }
        return new int[]{-1,-1};
    }
}
