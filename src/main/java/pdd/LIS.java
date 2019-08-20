package pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LIS {
    private static class Box{
        int length;
        int weight;
    }

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
        /*
        * 利用动态规划进行求解
        * 先对boxs[n]进行排序、排序规则，先长度，再重量
        * 构建状态opt[n][3]
        * opt[i][0]表示前i个所能堆的最大层数
        * opt[i][1]表示前i个所能堆的最大层数的最后一层的长度
        * opt[i][2]表示前i个所能堆最大层数的总重量
        * opt[0][0] = 1
        * opt[0][1] = boxs[1].length
        * opt[0][2] = boxs[1].weight
        * 状态转移方程如下：
        * if（opt[i-1][1] < boxs[i].length && opt[i-1][2] <= boxs[i].weigth * 7）
        * {
        *   opt[i][0] = opt[i-1][0]+1;
        *   opt[i][1] = boxs[i].length;
        *   opt[i][2] = opt[i-1][2] + boxs[i].weight;
        * }else{
        *   opt[i][0] = opt[i-1][0];
        *   opt[i][1] = opt[i-1][1];
        *   opt[i][2] = opt[i-1][2];
        * }
        */
        int[][] opt = new int[n][3];
        opt[0][0] = 1;
        opt[0][1] = boxs[0].length;
        opt[0][2] = boxs[0].weight;
        for (int i =1; i < n; i++){
            if(opt[i-1][1] < boxs[i].length && opt[i-1][2] <= boxs[i].weight * 7){
                opt[i][0] = opt[i-1][0]+1;
                opt[i][1] = boxs[i].length;
                opt[i][2] = opt[i-1][2] + boxs[i].weight;
            }else{
                opt[i][0] = opt[i-1][0];
                opt[i][1] = opt[i-1][1];
                opt[i][2] = opt[i-1][2];
            }
        }
        System.out.println(opt[n-1][0]);
    }
}
