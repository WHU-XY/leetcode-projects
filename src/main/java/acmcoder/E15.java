package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 13:12
 */
public class E15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        int l = 0;
        for (int i = 0; i < n-1; i++){
            if (a[i] > a[i+1]){
                l = i;
                break;
            }
        }
        int r = l;
        for (int i = l; i < n; i++){
            if (a[l] < a[i]){
                r = i-1;
                break;
            }
        }

        if (l == r){
            System.out.println("no");
            return;
        }

        for (int i = l; i < r; i++){
            if (a[i] <= a[i+1]){
                System.out.println("no");
                return;
            }
        }
        if(l != 0){
            if (a[r] <= a[l-1]){
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
        return;
    }
}
