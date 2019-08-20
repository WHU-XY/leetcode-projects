package acwing;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/19 14:12
 * 二维背包问题
 */
public class E6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int m = sc.nextInt();
        int[][] f = new int[v+1][m+1];
        for (int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            for (int j = v; j >= a; j--){
                for (int k = b; k >= b; k--){
                    f[j][k] = Math.max(f[i][j],f[j-a][k-b]+c);
                }
            }
        }
        System.out.println(f[v][m]);
    }
}
