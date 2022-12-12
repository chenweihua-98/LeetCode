package code.TwoPointer;

import java.util.Arrays;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ThreeSumClosest
 * 类 描 述：TODO 力扣题16 最接近的三数之和
 * 创建时间：2022/11/12 下午10:16
 * 创 建 人：chenweihua
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[]nums,int target){

        if (nums==null||nums.length<3){
            return 0;
        }

        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; ++i) {
            int l = i+1,r=nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (Math.abs(sum-target)<Math.abs(ans-target)){
                    ans = sum;
                }
                if(sum>target){
                    r--;
                }else if(sum<target){
                    l++;
                }else {
                    return target;
                }
            }
        }

        return ans;
    }


}
