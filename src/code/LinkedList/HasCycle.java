package code.LinkedList;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：HasCycle
 * 类 描 述：TODO 力扣题141给你一个链表的头节点 head ，判断链表中是否有环。
 * 创建时间：2022/10/15 上午10:02
 * 创 建 人：chenweihua
 */
public class HasCycle {

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }


    }

    public boolean hasCycle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        if (head==null||head.next==null){
            return false;
        }

        while (fast!=slow){
            if (fast==null||fast.next==null){
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return true;


    }


}
