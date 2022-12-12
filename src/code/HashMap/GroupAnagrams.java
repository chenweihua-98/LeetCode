package code.HashMap;

import java.util.*;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：GroupAnagrams
 * 类 描 述：TODO 力扣题49
 * 创建时间：2022/11/26 下午9:45
 * 创 建 人：chenweihua
 */
public class GroupAnagrams {

    public List<List<String>> groupAngrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }


}
