package code.LinkedList;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ReverseBetween
 * 类 描 述：TODO 力扣题92给你单链表的头指针 head 和两个整数 left 和 right ，
 *         其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
 * 创建时间：2022/10/15 上午11:33
 * 创 建 人：chenweihua
 */
public class ReverseBetween {


    class ListNode{
        int val ;
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
    //时间复杂度很高，最大需要遍历两次链表
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode pre = p;
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }
        
        
        ListNode rightNode = pre;
        for (int i = 0; i < right-left+1; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverseList(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;
        return p.next;

    }
    //一次遍历
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        //制造一个节点，方便返回，不打乱原有结构
        ListNode p =new ListNode(-1);
        p.next = head;
        ListNode pre = p;
        //到替换区间的前一个节点
        for(int i =0;i<left-1;i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for(int i =0;i<right-left;i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return p.next;
    }


    public void reverseList(ListNode head){
        ListNode temp = head;
        ListNode pre = null;
        ListNode next ;
        while (temp!=null){
            next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;

        }
    }






}
