package acwing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/19 9:18
 * 多重背包问题二进制解法
 */
public class E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] f = new int[m+1];
        ArrayList<Good> goods = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int v = sc.nextInt();
            int w = sc.nextInt();
            int s = sc.nextInt();
            for (int k = 1; k <= s; k*=2){
                s -= k;
                goods.add(new Good(k*v, k*w));
            }
            if (s > 0){
                goods.add(new Good(s*v, s*w));
            }
        }
        for (Good good : goods){
            for (int j = m; j >= good.v; j--){
                f[j] = Math.max(f[j], f[j-good.v] + good.w);
            }
            System.out.println(Arrays.toString(f));
        }
    }

    public static class Good{
        int v;
        int w;

        public Good(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
