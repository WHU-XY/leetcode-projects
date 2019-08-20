package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 19:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        int l = 0;
        int r = 0;
        for (int i = 0; i < n-1; i++){
            if (a[i] > a[i+1]){
                l = i;
                break;
            }
        }
        for (int i = l; i < n; i++){
            if (a[l] < a[i]){
                r = i-1;
                break;
            }
        }
        if (l == r || l > r){
            System.out.println("no");
            return;
        }
        for (int i = l; i < r; i++){
            if (a[i] < a[i+1]){
                System.out.println("no");
                return;
            }
        }
        if (l != 0){
            if (a[l-1] > a[r]){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
        return;
    }
}
