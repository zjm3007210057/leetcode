package link;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * Created by zjm on 2020/5/17 11:28
 */
public class MergeKLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for(int i = 0; i < lists.length; i++) {
            if(null != lists[i]) {
                queue.add(lists[i]);
            }
        }
        while(!queue.isEmpty()) {
            ListNode ln = queue.poll();
            tmp.next = ln;
            if(ln.next != null) {
                queue.add(ln.next);
            }
            tmp = tmp.next;
        }
        return head.next;
    }
}
