package code.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：DetectCycle
 * 类 描 述：TODO 力扣题142
 * 创建时间：2022/12/6 下午5:32
 * 创 建 人：chenweihua
 */
public class DetectCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //利用hash表求解
    public ListNode detectCycleHashSet(ListNode head) {
        Set<ListNode> visit = new HashSet<>();
        while (head != null) {
            if (visit.contains(head)) {
                return head;
            } else {
                visit.add(head);
            }
            head = head.next;
        }
        return head;
    }

    //利用快慢指针求解
    public ListNode detectCycleTwoPointer(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


}
