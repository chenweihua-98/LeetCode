package code.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：LengthOfLongestSubstring
 * 类 描 述：TODO 力扣题3 无重复字符的最长子串
 * 创建时间：2022/12/5 下午2:12
 * 创 建 人：chenweihua
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s){
        if (s.length()==0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0,left = 0;
        for (int i = 0;i<s.length();++i){
            if (map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i)));
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
