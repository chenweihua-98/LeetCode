package code.HashMap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Intersect
 * 类 描 述：TODO 力扣题350
 * 创建时间：2022/11/26 下午10:58
 * 创 建 人：chenweihua
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length<nums2.length?nums1.length:nums2.length;
        int[] res =new int[n];
        int index = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            if (map.containsKey(num)&&map.get(num)>0){
                res[++index] = num;
                map.put(num,map.get(num)-1);
            }
        }
        return Arrays.copyOfRange(res,0,++index);
    }
}
