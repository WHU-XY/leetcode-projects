package acmcoder;

import java.util.*;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 19:55
 */
public class E5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            boolean b = false;
            for (int i = 2; i <= n; i++){
                b = true;
                while (n%i == 0){
                    if (b){
                        list.add(i);
                    }
                    n /= i;
                    b = false;
                }
            }
            System.out.println(list);
        }
    }
}
