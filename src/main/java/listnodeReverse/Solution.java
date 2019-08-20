package listnodeReverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null){
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (!stack.isEmpty()){
//            arrayList.add(stack.pop());
//        }
//        return arrayList;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null){
            arrayList.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(arrayList);
        return arrayList;
    }
}
