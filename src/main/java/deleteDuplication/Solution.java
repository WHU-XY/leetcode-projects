package deleteDuplication;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode result = new ListNode(0);
        result.next = pHead;
        ListNode pre = result; //当前不重复的节点
        ListNode last = result.next; //工作指针
        while (last != null){
            if(last.next!=null && last.val == last.next.val){
                // 找到最后的一个相同节点
                while (last.next!=null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else{
                pre = pre.next;
                last = last.next;
            }
        }
        return result.next;
    }
}
