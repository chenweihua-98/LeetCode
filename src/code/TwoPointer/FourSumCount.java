package code.TwoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FourSumCount
 * 类 描 述：TODO 力扣题454 四数相加
 * 创建时间：2022/11/14 上午11:06
 * 创 建 人：chenweihua
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum12 = nums1[i]+nums2[j];
                map.put(sum12,map.getOrDefault(sum12,0)+1);
            }
        }

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum34 = -(nums3[i]+nums4[j]);
                if (map.containsKey(sum34)) res+=map.get(sum34);
            }
        }

        return  res;
    }
}
