package code.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ThreeSum
 * 类 描 述：TODO 力扣题15 三数和
 * 创建时间：2022/11/12 下午8:32
 * 创 建 人：chenweihua
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //结果数组
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        //对数组进行排序 默认增序
        Arrays.sort(nums);
        //取一个数 取他左边第一个以及最后一个
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            //删去重复值
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            //利用两个指针遍历
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //删去重复值
                    while (l < r && nums[l] == nums[l++]) {
                        l++;
                    }
                    //删去重复值
                    while (l < r && nums[r] == nums[r--]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }
        }
        return ans;
    }
}
