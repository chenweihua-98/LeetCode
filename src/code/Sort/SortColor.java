package code.Sort;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SortColor
 * 类 描 述：TODO 力扣题75 三种数 按照0,1,2分布
 * 创建时间：2022/10/13 上午11:18
 * 创 建 人：chenweihua
 */
public class SortColor {

    public void sortColors(int[] nums) {
        if(nums.length==2||nums==null){
            return;
        }
        partition(nums,0,nums.length-1,1);
    }

    public int[] partition(int[] nums , int L , int R, int p ){
        int less = L-1;
        int more = R+1;
        while(L<more){
            if(nums[L]<p){
                swap(nums,++less,L++);
            }else if(nums[L]>p){
                swap(nums,--more,L);
            }else{
                L++;
            }
        }
        return nums;
    }
    public void swap(int[]num,int i ,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
