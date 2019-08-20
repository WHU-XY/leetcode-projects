package addTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    public ListNode addTwoNumbersMy(ListNode l1, ListNode l2) {
        int a = 0;
        int b = 0;
        ListNode p = l1;
        ListNode q = l2;
        int bl = 1;
        while(p != null){
            a += p.val * bl;
            bl *= 10;
            p = p.next;
        }

        bl = 1;
        while(q != null){
            b += q.val * bl;
            bl *= 10;
            q = q.next;
        }

        int sum = a + b;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        //result.next = temp;
        while(sum != 0){

            temp.next = new ListNode(sum %10);

            sum /= 10;
            temp = temp.next;
        }

        return result.next;
    }
}
