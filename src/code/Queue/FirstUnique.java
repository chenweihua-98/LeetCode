package code.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：FirstUnique
 * 类 描 述：TODO 力扣题1429 第一个唯一数字
 * 创建时间：2022/11/22 下午10:58
 * 创 建 人：chenweihua
 */
public class FirstUnique {
    Queue<Integer> queue = new LinkedList<Integer>();
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public FirstUnique(int[] nums) {

        for (int i = 0; i < nums.length; ++i) {
            queue.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
            queue.poll();
        }

    }

    public int showFirstUnique() {
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public void add(int value) {
        queue.offer(value);
        map.put(value, map.getOrDefault(value, 0) + 1);
        while (!queue.isEmpty() && map.get(queue.peek()) > 1) {
            queue.poll();
        }
    }
}
