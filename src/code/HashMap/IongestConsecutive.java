package code.HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：IongestConsecutive
 * 类 描 述：TODO 力扣题128 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 创建时间：2022/10/28 下午3:37
 * 创 建 人：chenweihua
 */
public class IongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        for(int num :nums){
            if(!set.contains(num-1)){
                int currentSteak = 1;
                int currentNum = num ;
                while(set.contains(currentNum+1)){
                    currentSteak++;
                    currentNum++;
                }
                longestStreak = Math.max(longestStreak,currentSteak);
            }
        }
        return longestStreak;
    }

}
