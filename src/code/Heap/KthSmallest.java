package code.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：KthSmallest
 * 类 描 述：TODO 力扣题378 有序矩阵中第k小的元素
 * 创建时间：2022/11/5 下午3:27
 * 创 建 人：chenweihua
 */
public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        //建立小根堆优先队列，使得小的数放在队顶
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            return a[0] - b[0];
        });
        //行数
        int n = matrix.length;
        //因为每一行每一列都是递增的，所以矩阵中最小的数肯定在第一列中，将第一列数值存入，后面是所在行，所在列
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            //将队列中最小的数取出
            int[] now = pq.poll();
            //比较是否是该行最后一个
            if (now[2] != n - 1) {
                //如果不是最后一个，将该数右边第一个数存入优先队列
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }
}
