package code.Heap;

import java.util.PriorityQueue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MergeKLists
 * 类 描 述：TODO 力扣题23 合并k个升序链表
 * 创建时间：2022/11/4 下午8:41
 * 创 建 人：chenweihua
 */
public class MergeKLists {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，
    // 然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>((list1, list2) -> {
            return list1.val - list2.val;
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }

        return res.next;
    }


}



