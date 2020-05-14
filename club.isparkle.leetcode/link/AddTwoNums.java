package link;


import util.ListNode1;

/**
 * Created by zjm on 2020/4/26 21:35
 */
public class AddTwoNums {

    public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        if(l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }
        int index = 0;
        int sum = 0;
        while(l1 != null) {
            sum += Math.pow(10, index) * l1.val;
            index++;
            l1 = l1.next;
        }
        index = 0;
        while(l2 != null) {
            sum += Math.pow(10, index) * l2.val;
            l2 = l2.next;
            index++;
        }
        ListNode1 head = new ListNode1(0);
        ListNode1 tmp = head;
        while(sum > 0) {
            tmp.next = new ListNode1(sum % 10);
            tmp = tmp.next;
            sum /= 10;
        }
        return head.next;
    }

    public ListNode1 addTwoNumbersBetter(ListNode1 l1, ListNode1 l2) {
        if(l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }
        ListNode1 res = new ListNode1(1);
        ListNode1 tmp = res;
        int num = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }
            tmp.next = new ListNode1(num % 10);
            tmp = tmp.next;
            num /= 10;
        }
        if(num > 0) {
            tmp.next = new ListNode1(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i++);
        System.out.println(++i);
    }
}
