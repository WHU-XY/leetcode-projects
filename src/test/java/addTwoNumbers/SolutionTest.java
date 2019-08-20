package addTwoNumbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = l3;
        int i = 6;
        while (i > 0){
            temp1.next = new ListNode(i);
            temp2.next = new ListNode(7-i);
            temp3.next = new ListNode(7);
            temp1 = temp1.next;
            temp2 = temp2.next;
            temp3 = temp3.next;
            i--;
        }
        assertEquals(l3.next, new Solution().addTwoNumbers(l1.next, l2.next));
    }

    @Test
    public void addTwoNumbersMy() {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp3 = l3;
        int i = 6;
        while (i > 0){
            temp1.next = new ListNode(i);
            temp2.next = new ListNode(7-i);
            temp3.next = new ListNode(7);
            temp1 = temp1.next;
            temp2 = temp2.next;
            temp3 = temp3.next;
            i--;
        }
        assertEquals(l3.next, new Solution().addTwoNumbersMy(l1.next, l2.next));
    }
}