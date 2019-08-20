package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 14:52
 */
public class E19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] stops = new int[n][2];
        int max = 0;
        int num = 0;
        for (int i = 0; i < n; i++){
            stops[i][0] = sc.nextInt();
            num -= stops[i][0];
            stops[i][1] = sc.nextInt();
            num += stops[i][1];
            max = Math.max(max, num);
        }
        sc.close();
        System.out.println(max);
    }
}
