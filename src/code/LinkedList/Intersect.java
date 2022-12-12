package code.LinkedList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Intersect
 * 类 描 述：TODO
 * 创建时间：2022/10/29 下午10:49
 * 创 建 人：chenweihua
 */
public class Intersect {

    public int[] intersect(int[] nums1,int[]nums2){
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int num :nums1){
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for(int num:nums2){
            int count = map.getOrDefault(num,0);
            if(count>0){
                intersection[index++] = num;
                count--;
                if(count==0){
                    map.remove(num);
                }else{
                    map.put(num,count);
                }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);

    }
}
