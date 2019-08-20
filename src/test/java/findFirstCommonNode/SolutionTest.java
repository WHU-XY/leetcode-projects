package findFirstCommonNode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findFirstCommonNode() {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(5);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(8);
        ListNode p6 = new ListNode(2);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        //p6.next = p4;
        System.out.println(new Solution().FindFirstCommonNode(p1,p6).val);
    }
}