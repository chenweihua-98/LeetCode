package code.LinkedList;

import java.util.List;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ReverseList
 * 类 描 述：TODO 力扣题206
 * 创建时间：2022/10/14 下午1:16
 * 创 建 人：chenweihua
 */
public class ReverseListPlus {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //反转链表的迭代写法
    public static void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode next;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }

    //反转链表的递归写法
    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


}
