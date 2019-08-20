package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 14:22
 */
public class E18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            if (n == 0 && m == 0 && k == 0)
                return;
            int t = 0;
            int i = 0;
            //一个周期为2*n-2
            while (true){
                if(m == 1 || m == n){
                    if (check(m+(2*n-2)*i)){
                        t++;
                        if (t == k){
                            System.out.println(m+(2*n-2)*i);
                            break;
                        }
                    }
                }else {
                    if (check(m+(2*n-2)*i)){
                        t++;
                        if (t == k){
                            System.out.println(m+(2*n-2)*i);
                            break;
                        }
                    }
                    if (check(2*n-m+(2*n-2)*i)){
                        t++;
                        if (t == k){
                            System.out.println(2*n-m+(2*n-2)*i);
                            break;
                        }
                    }
                }
                i++;
            }
        }
    }
    public static boolean check(int n){
        if (n % 7 == 0){
            return true;
        }
        if (String.valueOf(n).indexOf("7") != -1){
            return true;
        }
        return false;
    }
}
