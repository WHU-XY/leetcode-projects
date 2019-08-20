package acmcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 15:22
 */
public class E22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        ArrayList<Integer> rs = new ArrayList<>();
        for (int i = 1; i < n-1; i++){
            int temp = 0;
            for (int j = 0; j < n-1; j++){
                if ((j+1) == i){
                    temp = Math.max(temp, a[j+2] -a[j]);
                    continue;
                }
                if (j == i){
                    continue;
                }
                temp = Math.max(temp, a[j+1] -a[j]);
            }
            rs.add(temp);
        }
        Collections.sort(rs);
        System.out.println(rs.get(0));
    }
}
