package code.LinkedList;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：MiddleNode
 * 类 描 述：TODO  力扣题876 给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 * 创建时间：2022/10/14 下午4:06
 * 创 建 人：chenweihua
 */
public class MiddleNode {

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

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }


}
