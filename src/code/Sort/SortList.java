package code.Sort;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：SortList
 * 类 描 述：TODO 力扣题目148以及21 给你链表的头结点 head ，请将其按升序排列并返回 排序后的链表
 * 创建时间：2022/10/4 上午11:48
 * 创 建 人：chenweihua
 */
public class SortList {

    //单链表结构
    static class ListNode {
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

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //设快慢指针找到链表中点，链表奇数个点找到中点，偶数个找中左的点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //将链表从中点截断 tmp链表右段 head链表左段
        ListNode tmp = slow.next;
        slow.next = null;
        //对拆分的左右两段继续递归
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        return mergeTwoLists(left, right);
    }

    //题目21 将两个链表合并成一个升序链表并返回
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                h.next = list1;
                list1 = list1.next;
            }else{
                h.next = list2;
                list2 = list2.next;
            }
            h = h.next;
        }
        h.next = list1!=null?list1:list2;
        return res.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        listNode.next = new ListNode(3);
        listNode.next.next=new ListNode(4);
        listNode.next.next.next = new ListNode(14);
        ListNode resnode = sortList(listNode);
        while (resnode!=null){
            System.out.println(resnode.val);
            resnode = resnode.next;
        }
    }


}
