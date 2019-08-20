package acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/19 9:18
 * 多重背包问题
 */
public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] v = new int[n+1];
        int[] w = new int[n+1];
        int[] s = new int[n+1];
        int[][] f = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++){
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        /*
        * 优化
        * 从大到小枚举
        * 对于第i个保证前面i-1个已经最优
        * */
        int[] newf = new int[m+1];
        for (int i = 1; i < n+1; i++){
            for (int j = m; j >= v[i] ; j--){
                for (int k = 0; k*v[i] <= j && k <= s[i]; k++){
                    newf[j] = Math.max(newf[j],newf[j-k*v[i]]+k*w[i]);
                }
                System.out.println(Arrays.toString(newf));
            }
        }
    }
}
