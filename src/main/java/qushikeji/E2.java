package qushikeji;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/8 21:06
 */
//1 5 10 20 50 100
public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] size = new int[6];
        for (int i = 0; i < 6; i++){
            size[i] = sc.nextInt();
        }
        int chargeNum = sc.nextInt();
        sc.close();
    }
}
