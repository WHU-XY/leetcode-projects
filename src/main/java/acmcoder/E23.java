package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 15:40
 */
public class E23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] balls = new int[4];
        int length = 0;
        for (int i = 0; i < 4; i++){
            balls[i] = sc.nextInt();
            while (balls[i] != 0){
                length += balls[i];
                balls[i] /= 2;
                length += balls[i];
            }
        }
        sc.close();
        System.out.println(length);
    }
}
