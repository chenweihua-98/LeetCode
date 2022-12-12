package code.Heap;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：RemoveDuplicates
 * 类 描 述：TODO 力扣题26删除有序数组中的重复项
 * 创建时间：2022/11/6 下午4:08
 * 创 建 人：chenweihua
 */
public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int slow =0;
        int fast = 1;
        while(fast<nums.length){
            if(nums[slow]==nums[fast]){
                fast++;
            }else{
                nums[++slow] = nums[fast++];
            }
        }
        return ++slow;
    }
}
