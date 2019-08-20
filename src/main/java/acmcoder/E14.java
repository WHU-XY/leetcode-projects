package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 12:56
 */
public class E14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(getResult(sc.nextInt()));
        }
    }
    public static int getResult(int day){
        /*
        * 第n天
        * 共增z天
        * 共跌d天
        * 则n = z + d
        * 且有 d*（d+1）/2+1+d<=n
        * 求出满足不能式d的最大值 d <= 根号（2n+0.25）-1.5
        * 那么结果为1+(n-d)-d
        * 即n-2*d+1*/
        int d = (int)(Math.sqrt(2*day+0.25)-1.5);
        return (day-2*d);
    }
}
