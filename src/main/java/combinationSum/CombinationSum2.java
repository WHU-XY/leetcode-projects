package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/20 14:07
 * 多重背包问题，01背包但是里面有重复元素，解决办法是排序，下一次的选择都往后移
 * 所求组合对元素顺序无要求
 * 如果所求组合对元素顺序有要求详见Combination5
 */
public class CombinationSum2 {
    // residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
    // residue 在递归遍历中，只会越来越小
    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            // 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {1,1,2,2,5};
        int target = 5;
        CombinationSum2 solution = new CombinationSum2();
        List<List<Integer>> combinationSum2 = solution.combinationSum2(candidates, target);
        System.out.println(combinationSum2);
    }
}
