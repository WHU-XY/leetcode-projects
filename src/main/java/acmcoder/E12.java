package acmcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 11:05
 */
public class E12 {
    public static void main(String[] args) {
        /*
        * dp[i][j] j代表起始位置
        *          i代表剩余次数
        **/
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int dp[][] = new int [m+1][n+1];
        dp[0][1]=1;
        dp[1][n]=1;
        dp[1][2]=1;
        for(int i=1;i <= m;i++) {
            for(int j=1;j <= n;j++) {
                if(j == 1)
                    dp[i][j]=dp[i-1][n]+dp[i-1][2];
                else if(j==n)
                    dp[i][j]=dp[i-1][1]+dp[i-1][n-1];
                else
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
            }
        }
        for (int i = 0; i < m+1; i++)
            System.out.println(Arrays.toString(dp[i]));
        System.out.println(dp[m][1]);

    }

}
