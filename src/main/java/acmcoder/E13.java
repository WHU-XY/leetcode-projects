package acmcoder;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 11:41
 */
public class E13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> list = getResult(a[i]);
            for (Integer t : list)
                System.out.print(t+" ");
            System.out.println();
        }
    }

    public static ArrayList<Integer> getResult(int num){
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 1; i <= num; i++){
            data.add(i);
        }
        int s = 2;
        while (data.size() > 3){
            if (s == 2){
                for (int i = s; i <= data.size(); i++){
                    data.remove(i-1);
                }
                s = 3;
                continue;
            }
            if (s == 3){
                for (int i = s; i <= data.size(); i = i+2){
                    data.remove(i-1);
                }
                s = 2;
                continue;
            }

        }
        return data;
    }
}
