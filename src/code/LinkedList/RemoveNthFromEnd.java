package code.LinkedList;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：RemoveNthFromEnd
 * 类 描 述：TODO 力扣题19 删除链表的倒数第 N 个结点
 * 创建时间：2022/11/6 下午3:14
 * 创 建 人：chenweihua
 */
public class RemoveNthFromEnd {

    class ListNode{
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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        //添加一个哑节点（dummy node），它的 next指针指向链表的头节点 避免特殊情况的讨论
        ListNode dummy = new ListNode(0,head);
        ListNode p = dummy,pre = dummy;
        int len = 0;
        while(p!=null){
            len++;
            p=p.next;
        }
        for(int i  = 0;i<len-n-1;++i){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }

}
