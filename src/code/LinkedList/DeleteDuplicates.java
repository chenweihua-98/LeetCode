package code.LinkedList;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：DeleteDuplicates
 * 类 描 述：TODO 力扣题83删除排序链表中的重复元素
 * 创建时间：2022/11/6 下午4:38
 * 创 建 人：chenweihua
 */
public class DeleteDuplicates {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //自己想的
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
                slow.next = null;
            } else {
                slow.next = fast;
                slow = slow.next;
            }
        }
        return head;
    }

    //题解答案
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
