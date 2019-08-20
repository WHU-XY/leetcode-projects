package combinationSum;

import java.util.*;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/20 10:24
 * 满足条件的组合（回溯+剪枝），完全背包问题，没有重复元素，每次i不变，需要对数组排序
 * 满足的组合不对顺序做要求（递归start=i）
 * 如果对组合的顺序有要求（递归start=0，即i=0）
 * 如果对数组元素个数有要求则变成多重背包问题详见Combination2
 * 如果对数组元素个数有要求而且对顺序也有要求则详见Combination5
 */
public class CombinationSum1 {
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            //# Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            res.add(new ArrayList<>(pre));
            return;
        }
        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            findCombinationSum(residue - candidates[i], 0, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {1, 2, 5};
        int target = 5;
        CombinationSum1 solution = new CombinationSum1();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
