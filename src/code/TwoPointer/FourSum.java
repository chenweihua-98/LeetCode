package code.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FourSum
 * 类 描 述：TODO 力扣题18 四数之和
 * 创建时间：2022/11/13 下午1:32
 * 创 建 人：chenweihua
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < nums.length-3; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[i]+nums[length-3]+nums[length-2]+nums[length-1]<target){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if(j>i+1&&nums[j]==nums[j-1]) {
                    continue;
                }
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if (nums[i]+nums[j]+nums[length-2]+nums[length-1]<target){
                    continue;
                }
                int l = i+1,r = length-1;
                while (l<r){
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        if (l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        if (l<r&&nums[r] ==nums[r-1]){
                            r--;
                        }
                        r--;
                        l++;
                    }else if(sum<target){
                        l++;
                    }else if(sum>target){
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
