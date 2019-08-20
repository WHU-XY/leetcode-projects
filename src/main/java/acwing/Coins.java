package acwing;

import java.util.*;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/19 14:49
 * 硬币兑换 完全背包
 * dp[i]表示目标为i元有几种兑换方式
 */
public class Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        Map<Integer, ArrayList<ArrayList<Integer>>> plans = new HashMap<>();
        //plans.put(0, new ArrayList<>());
        for (int coin : coins) {
            // 记录每添加一种面额的零钱，总金额j的变化
            for (int j = 1; j <= target; j++) {
                if (j >= coin) {
                    // 在上一钟零钱状态的基础上增大
                    // 例如对于总额5，当只有面额为1的零钱时，只有一种可能 5x1
                    // 当加了面额为2的零钱时，除了原来的那一种可能外
                    // 还加上了组合了两块钱的情况，而总额为5是在总额为3的基础上加上两块钱来的
                    // 所以就加上此时总额为3的所有组合情况
                    dp[j] = dp[j] + dp[j - coin];
                    if (plans.containsKey(j) && plans.containsKey(j-coin)){
                        ArrayList<ArrayList<Integer>> a  = plans.get(j);
                        ArrayList<ArrayList<Integer>> b  = plans.get(j-coin);
                        for (ArrayList<Integer> lista : a){
                            for (ArrayList<Integer> listb : b){
                                lista.addAll(listb);
                            }
                        }
                    }else if (!plans.containsKey(j) && !plans.containsKey(j-coin)){
                        ArrayList<ArrayList<Integer>> t = new ArrayList<>();
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(coin);
                        t.add(list);
                        plans.put(j,t);
                    }else if (!plans.containsKey(j) && plans.containsKey(j-coin)){
                        plans.put(j, plans.get(j-coin));
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
            for (Map.Entry<Integer, ArrayList<ArrayList<Integer>>> entry : plans.entrySet()){
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
        }
    }
}
