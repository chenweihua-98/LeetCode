package code.Heap;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：Partition
 * 类 描 述：TODO 力扣题86
 * 创建时间：2022/11/29 下午7:36
 * 创 建 人：chenweihua
 */
public class Partition {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode large = largeHead;

        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        large.next =null;
        small.next = largeHead.next;
        return smallHead.next;


    }
}
