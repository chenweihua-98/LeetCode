package code.Heap;

import java.util.TreeMap;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：IongestSubarray
 * 类 描 述：TODO 力扣题1438
 * 创建时间：2022/12/2 上午11:43
 * 创 建 人：chenweihua
 */
public class IongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0, res = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
