package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 15:15
 */
public class E21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int k = n;
        int result = n;
        while (k >=3){
            result += k/3;
            k = k/3 + k%3;
        }
        System.out.println(result);
    }
}
