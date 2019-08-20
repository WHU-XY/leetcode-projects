package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 10:23
 */
public class E11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++){
            m[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < n; i++){
            System.out.println(getKinds(m[i]));
        }
    }

    public static int getKinds(int end){
        int[] opt = new int[end+1];
        if (end <= 1){
            return 0;
        }
        if (end == 2){
            return 1;
        }
        if (end ==3){
            return 2;
        }
        opt[1] = 0;
        opt[2] = 1;
        opt[3] = 2;
        for (int i = 4; i < end+1; i++){
            opt[i] = opt[i-1] + opt[i-2];
        }
        return opt[end];
    }
}
