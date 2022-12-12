package code.Heap;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Merge
 * 类 描 述：TODO 力扣题88 合并两个有序数组
 * 创建时间：2022/11/5 下午1:41
 * 创 建 人：chenweihua
 */
public class Merge {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=0,p1=0,p2=0;
        int[] nums = new int[m+n];
        while(p1<m&&p2<n){
            if(nums1[p1]<nums2[p2]){
                nums[p++] = nums1[p1++] ;
            }else{
                nums[p++] = nums2[p2++];
            }
        }
        if(p1<m){
            while(p1<m){
                nums[p++] =nums1[p1++];
            }
        }
        if(p2<n){
            while(p2<n){
                nums[p++] =nums2[p2++];
            }
        }
        for(int i = 0;i<nums.length;i++){
            nums1[i] = nums[i];
        }
    }


}
