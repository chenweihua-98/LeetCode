package code.LinkedList;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Partition
 * 类 描 述：TODO 力扣题86 分隔链表 给你一个链表的头节点 head 和一个特定值 x ，
 *          请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 创建时间：2022/11/4 下午3:06
 * 创 建 人：chenweihua
 */
public class Partition {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }


    }


    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode smallHead = small;
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                largeHead.next = head;
                largeHead = largeHead.next;
            }
            head = head.next;
        }
        largeHead.next = null;
        smallHead.next = large.next;
        return small.next;
    }
}
