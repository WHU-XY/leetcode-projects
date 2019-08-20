package acwing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/19 9:18
 * 混合背包问题
 */
public class E5 {
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
            if(s < 0){
                goods.add(new Good(-1,v,w));
            }else if (s == 0){
                goods.add(new Good(0,v,w));
            }else {
                for (int k = 1; k <= s; k*=2){
                    s -= k;
                    goods.add(new Good(-1,k*v, k*w));
                }
                if (s > 0){
                    goods.add(new Good(-1,s*v, s*w));
                }
            }

        }
        for (Good good : goods){
            if (good.kind  < 0){
                for (int j = m; j >= good.v; j--){
                    f[j] = Math.max(f[j], f[j-good.v] + good.w);
                }
            }else {
                for (int j = good.v; j >= m; j++){
                    f[j] = Math.max(f[j], f[j-good.v] + good.w);
                }
            }

        }
    }

    public static class Good{
        int kind;
        int v;
        int w;

        public Good(int kind, int v, int w) {
            this.kind = kind;
            this.v = v;
            this.w = w;
        }
    }
}
