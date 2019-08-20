package acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/19 9:18
 * 01背包问题
 */
public class E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] v = new int[n+1];
        int[] w = new int[n+1];
        int[][] f = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        /*
        * f[i][j] 表示只看前i个物品，总体积是j的情况下，总价值最大是多少
        * result = max{f[n][0-m]}
        * 1.不选第i个物品 f[i][j] = f[i-1][j]
        * 2.选第i个物品 f[i][j] = f[i-1][j-v[i]] + w[i];
        * f[i][j] = max{1.,2.}
        * */
        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j <= m; j++){
                f[i][j] = f[i-1][j];
                if (j >= v[i]){
                  int a = f[i-1][j];
                  int b = f[i-1][j-v[i]] + w[i];
                  f[i][j] = Math.max(a, b);
                }
            }
        }
        for (int i = 0; i < n + 1; i++){
            System.out.println(Arrays.toString(f[i]));
        }
        System.out.println("============================");
        /*
        * 优化
        * 从大到小枚举
        * 对于第i个保证前面i-1个已经最优
        * */
        int[] newf = new int[m+1];
        for (int i = 1; i < n+1; i++){
            for (int j = m; j >= v[i] ; j--){
                newf[j] = Math.max(newf[j], newf[j-v[i]]+w[i]);
                System.out.println(Arrays.toString(newf));
            }
        }
    }
}
