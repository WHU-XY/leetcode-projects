package acmcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 20:14
 */
public class E6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        sc.close();
        int num = 0;
        int[] pNum = new int[n];
        for (int i = 0; i < n; i++){
            num -= a[i];
            num += b[i];
            pNum[i] = num;
        }
        Arrays.sort(pNum);
        System.out.println(pNum[n-1]);
    }
}
