package acmcoder;

import java.util.Map;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 9:32
 */
public class E9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++){
            weight[i] = sc.nextInt();
        }
        int[][] option = new int[m][3];
        for (int i = 0; i < m; i++){
            option[i][0] = sc.nextInt();//操作数
            option[i][1] = sc.nextInt();//起始编号
            option[i][2] = sc.nextInt();//终止编号
        }
        for (int i = 0; i < m; i++){
            if (option[i][0] == 2){
                System.out.println(getSum(weight, option[i][1], option[i][2]));
            }else if (option[i][0] == 3){
                System.out.println(getMax(weight, option[i][1], option[i][2]));
            }
        }
    }

    public static int getSum(int[] weight, int start, int end){
        int sum = 0;
        for (int i = start-1; i < end; i++){
            sum += weight[i];
        }
        return sum;
    }

    public static int getMax(int[] weight, int start, int end){
        int max = 0;
        for (int i = start-1; i < end; i++){
            max = Math.max(max, weight[i]);
        }
        return max;
    }
}
