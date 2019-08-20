import addTwoNumbers.ListNode;
import jdk.nashorn.internal.ir.BinaryNode;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;


public class Solution implements Callable {
    //byte[] a = new byte[1024*100]; //100KB

//    boolean flag = false;
//        for (int i = 1; i < 4; i++) {
//        for (int j = 0; j < 4; j++) {
//            if(j==2) {
//                flag = true;
//                break;
//            }else {
//                System.out.println("i=" + i + " ;j=" + j);
//            }
//        }
//        if (flag) {
//            break;
//        }
//    }
//    List<Integer> list = new ArrayList<>();
//    List<Integer> list1 = new LinkedList<>();
//
//    Iterator<Integer> iterator = list.iterator();
//    ListIterator listIterator = list.listIterator();
//    Stack<String> stack = new Stack<>();
//    Queue<String> queue = new LinkedList<>();
//    Map<Integer,String> map = new HashMap<>();
//    Set<Integer> set = new HashSet<>();
//        Collections.sort(list);
//    int[] a = new int[24];
//        Arrays.sort(a);
//        Math.pow(10,2);

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list,nums,4,0,new int[4],new boolean[nums.length],0);
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
//            for (int j = 0; j < list.get(i).size(); j++){
//                System.out.print(list.get(i).get(j)+" ");
//            }
//            System.out.println();
        }
    }
    public static void backtrack(List<List<Integer>> list, int[] nums, int t,int k,int[] temp,boolean[] hash, int target){
        if(k == t){
            int sum = 0;
            List<Integer> listT = new ArrayList<>();
            for (int i = 0; i < t; i++){
                sum += temp[i];
                listT.add(temp[i]);
            }
            if (sum == target){
                list.add(listT);
            }
            return;
        }
        for (int i = 0;i < nums.length;i++)
            //如果不在候选答案向量中则添加该字母
            if( !hash[i] )
            {
                hash[i] = true;
                temp[k] = nums[i];
                backtrack(list,nums, t, k+1,temp,hash,target);
                //下一个for循环的时候就是放该层的
                // 下一个可以放的字母，这轮循环放的是这个字母
                //那么下一轮循环显然放的不是这个字母了，那么这个字母需要被
                //移除出hash表
                //temp[i] = ' ';
                hash[i] = false;
            }
    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
