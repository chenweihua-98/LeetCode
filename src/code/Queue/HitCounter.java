package code.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：HitCounter
 * 类 描 述：TODO 力扣题362
 * 创建时间：2022/11/23 上午10:51
 * 创 建 人：chenweihua
 */
public class HitCounter {
    Queue<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<Integer>();
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        if (queue.size() == 0) {
            return 0;
        }
        while (queue.peek() < timestamp - 299) {
            queue.poll();
            if (queue.size() == 0) {
                return 0;
            }
        }
        return queue.size();
    }
}
