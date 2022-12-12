package List;


/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ReverseList 单链表以及双链表的反转
 * 类 描 述：TODO
 * 创建时间：2022/9/27 下午3:21
 * 创 建 人：chenweihua
 */
public class ReverseList {


    //单链表结构
    public static class Node {
        int value;
        Node next;

        Node() {
        }

        Node(int val) {
            this.value = val;
        }

        Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }
    }


    public static Node reverseList(Node head) {
        Node prev = null; //表示当前节点的前一个节点，初始值为null
        Node temp = head; //表示当前节点，初始值为head
        Node next; //表示当前节点的下一个节点
        while (temp != null) {
            //先提前保存当前节点的下一个节点
            next = temp.next;
            //将当前节点的next指针指向当前节点的前一个节点
            temp.next = prev;
            //更新prev，即将temp赋值给prev
            prev = temp;
            //更新temp，即将next赋值给temp
            temp = next;
        }
        return prev; //退出循环时temp为null，那么temp的前一个节点prev即为新的头结点
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }


}
