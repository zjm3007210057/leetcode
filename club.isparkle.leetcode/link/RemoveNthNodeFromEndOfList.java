package link;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Follow up: Could you do this in one pass?
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * Created by zjm on 2021/6/2 14:48
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = head;
        ListNode fast = head;
        for(int i = 0; i < n; i++) {
            if(fast == null) {
                return h;
            }
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            head = head.next;
        }
        head.next = head.next.next;
        return h;
    }

    public ListNode removeNthFromEndBetter(ListNode head, int n) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            if(n == 0) {
                pre = head;
            }else if(n < 0) {
                pre = pre.next;
            }
            cur = cur.next;
            n--;
        }
        if(n > 0) {
            return head;
        }
        if(pre == null) {//删除的是头结点，要换头
            return head.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
