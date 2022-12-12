package code.LinkedList;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：GetIntersectionNode
 * 类 描 述：TODO 力扣题160 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 创建时间：2022/10/14 下午3:48
 * 创 建 人：chenweihua
 */
public class GetIntersectionNode {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }
    }

    //让两个指针分别指向两个链表A和B 让他们分别走完A+B和B+A的路程 因为路程相同 若相交两个指针必相遇在某一个点，否则最后都指向null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        //当p1和p2指向相遇点时或者两点均指向null时，跳出循环
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return  p1;
    }


}
