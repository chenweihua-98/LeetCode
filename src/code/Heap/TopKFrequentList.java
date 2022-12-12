package code.Heap;

import java.util.*;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：TopKFrequentList
 * 类 描 述：TODO 力扣题692 前K个高频单词
 * 创建时间：2022/11/5 下午2:37
 * 创 建 人：chenweihua
 */
public class TopKFrequentList {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(( a,  b) -> {
            return a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue();
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().getKey());
        }
        Collections.reverse(list);
        return list;

    }
}
