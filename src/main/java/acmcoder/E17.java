package acmcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 14:07
 */
public class E17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        sc.close();
        int[][] nums = new int[t][n];
        int nap = 0;
        int temp = 1;
        for (int i = 0; i < t; i++){
            for (int j = 0; j < n; j++){
                temp +=nap;
                if (temp > k){
                    temp %= k;
                }
                nums[i][j] = temp;
                nap++;
            }
        }
        int result = 0;
        for (int i = 0; i < t; i++){
            result += nums[i][0];
        }
        System.out.println(result);
    }
}
