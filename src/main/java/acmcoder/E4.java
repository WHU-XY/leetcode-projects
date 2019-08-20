package acmcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 19:43
 */
public class E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        double width = 0;
        Arrays.sort(a);
        for (int i = 0; i < n; i++){
            if (i == 0){
                width = Math.max(width,a[i]);
            }else if(i < n-1){
                width = Math.max(width,(a[i]-a[i-1])/2.0);
            }else {
                width = Math.max(width, l - a[i]);
            }
        }
        System.out.println(String.format("%.2f",width));
    }
}
