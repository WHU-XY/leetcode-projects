package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 19:24
 */
public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String as = sc.nextLine();
        String bs = sc.nextLine();
        char[] a = as.toCharArray();
        char[] b = bs.toCharArray();
        System.out.println(a.length);
        System.out.println(b.length);
        sc.close();
        for (int i = 0; i < a.length; i++){
            if ((a[i]<='9'&&a[i]>='0')||(a[i]<='z'&&a[i]>='a')||(a[i]<='Z'&&a[i]>='A')){
                a[i] = '1';
            }else {
                a[i] = '0';
            }
        }
        int data = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] == b[i])
                data++;
        }
        double result = data*1.0/a.length*100;
        System.out.println(String.format("%.2f%%",result));
    }
}
