package link;

/**
 * Created by zjm on 2020/3/4 21:42
 */
public class ReverseList {

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp = head.next;
        Node newHead = reverse(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
//        reverseList(head);
        reverse(head);
    }

    private static class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
        }
    }
}
