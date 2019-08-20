package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 15:04
 */
public class E20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int[][] xy = new int[4][4];
        int rs = 0;
        for (int i = 0; i < 4; i++){
            xy[i][0] = sc.nextInt();
            xy[i][1] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < 3; i++){
            if (check(xy[i][0],xy[i][1],xy[3][0],xy[3][1],r)){
                rs++;
            }
        }
        System.out.println(rs+"X");
    }
    public static boolean check(int x, int y, int x0, int y0, int r){
        if (Math.sqrt(Math.pow(x-x0,2)+Math.pow(y-y0,2)) <= r*1.0){
            return true;
        }
        return false;
    }
}
