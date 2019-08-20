package combinationSum;

import java.util.*;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/20 15:41
 * 多重背包问题可以转换成完全背包问题（要加限制条件）
 * 第一步选统计每个数组元素出现的次数
 * 一个int[]数组,存放不同的元素
 * 一个Map,键为数组元素，值为剩余的个数，初始值为每个元素重复的次数
 */
public class CombinationSum5 {
    // residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
    // residue 在递归遍历中，只会越来越小
    private void findCombinationSum5(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res, Map<Integer,Integer> map) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            if (map.get(candidates[i]) == 0){
                continue;
            }
            stack.add(candidates[i]);
            map.put(candidates[i],map.get(candidates[i])-1);
            findCombinationSum5(candidates, 0, len, residue - candidates[i], stack, res, map);
            map.put(candidates[i],map.get(candidates[i])+1);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum5(int[] candidates, int target,Map<Integer,Integer> map) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        findCombinationSum5(candidates, 0, len, target, new Stack<>(), res,map);
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {1,2,5};
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(5,1);
        int target = 5;
        CombinationSum5 solution = new CombinationSum5();
        List<List<Integer>> combinationSum5 = solution.combinationSum5(candidates, target, map);
        System.out.println(combinationSum5);
    }
}
