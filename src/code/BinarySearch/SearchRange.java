package code.BinarySearch;

import java.lang.annotation.Target;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SearchRange
 * 类 描 述：TODO 力扣题34 在排序数组中查找元素的第一个和最后一个位置
 * 创建时间：2022/11/8 下午5:47
 * 创 建 人：chenweihua
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        //找到第一个>=target的数,再找>target的第一个数
        int l = search(nums,target);
        int r = search(nums,target+1);
        if(l>=nums.length||nums[l]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{l,r-1};
    }

    private int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid =(l+r)>>1;
            if(nums[mid]< target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return  l ;
    }
}
