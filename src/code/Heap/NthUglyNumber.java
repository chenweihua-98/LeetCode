package code.Heap;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：NthUglyNumber
 * 类 描 述：TODO 力扣题264
 * 创建时间：2022/11/28 下午7:54
 * 创 建 人：chenweihua
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] nums = new int[]{2, 3, 5};
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.offer(1L);

        for (int i = 1; i <= n; ++i) {
            long x = pq.poll();
            if (i == n) {
                return (int) x;
            }
            for (int num : nums) {
                Long temp = x * num;
                if (!set.contains(temp)) {
                    set.add(temp);
                    pq.offer(temp);
                }
            }
        }
        return -1;

    }

}
