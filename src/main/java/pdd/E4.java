package pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Box[] boxs = new Box[n];
        for (int i = 0; i < n; i++){
            boxs[i] = new Box();
            boxs[i].length = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            boxs[i].weight = sc.nextInt();
        }
        sc.close();
        Arrays.sort(boxs, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o1.length == o2.length ? (o1.weight - o2.weight) : (o1.length - o2.length);
            }
        });

        int res = 1;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = boxs[0].weight;
        for(int i = 1; i < n; ++i) {
            int prevMax = 0;
            int maxj = 0;
            for(int j = 0; j < i; ++j) {
                if(boxs[j].length < boxs[i].length && dp[j][1] <= boxs[i].weight*7) {
                    if(dp[j][0] > prevMax) {
                        prevMax = dp[j][0];
                        maxj = j;
                    }
                }
            }
            dp[i][0] = prevMax + 1;
            dp[i][1] = dp[maxj][1] + boxs[i].weight;
            res = Math.max(dp[i][0], res);
        }
        System.out.println(res);
    }
    private static class Box{
        int length;
        int weight;
    }
}
