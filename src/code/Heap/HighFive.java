package code.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：HighFive
 * 类 描 述：TODO 力扣题1086
 * 创建时间：2022/11/29 下午6:29
 * 创 建 人：chenweihua
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int number = item[0], score = item[1];
            if (map.containsKey(number)) {
                map.get(number).offer(score);
            } else {
                PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
                    return b - a;
                });
                queue.offer(score);
                map.put(number, queue);
            }
        }
        int sum = 0;
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            for (int i = 0; i < 5; ++i) {
                PriorityQueue<Integer> queue = entry.getValue();
                sum += queue.poll();
            }
            res[index++] = new int[]{entry.getKey(), sum / 5};
        }

        return res;
    }
}
