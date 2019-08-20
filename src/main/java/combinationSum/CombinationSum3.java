package combinationSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/20 14:46
 * 01背包问题，添加限制条件，栈的大小，相减的值不能为负（否则提前结束）
 * 无重复元素
 * 对顺序无要求
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        findCombination(n,1,k,new Stack<Integer>(),res);
        return res;
    }
    public void findCombination(int residue,int begin,int k,Stack<Integer> stack, List<List<Integer>> res){
        if(residue == 0 && stack.size() == k){
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int i = begin; i <=9 && stack.size() < k && (residue - i) >= 0; i++){
            stack.add(i);
            findCombination(residue-i, i+1,k,stack,res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        CombinationSum3 soulution = new CombinationSum3();
        System.out.println(soulution.combinationSum3(3,7));
    }
}
