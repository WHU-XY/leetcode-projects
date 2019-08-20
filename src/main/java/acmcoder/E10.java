package acmcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 9:45
 */
public class E10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0){
                sc.close();
                return;
            }
            int[][] fellowTownsman = new int[m][2];
            for (int i = 0; i < m; i++){
                fellowTownsman[i][0] = sc.nextInt();
                fellowTownsman[i][1] = sc.nextInt();
            }
            System.out.println(getFellowTownsmanNum(fellowTownsman));
        }
    }

    public static int getFellowTownsmanNum(int[][] fellowTownsman){
        Set<Integer> rs = new HashSet<>();
        //System.out.println(fellowTownsman.length);
        for (int i = 0; i < fellowTownsman.length; i++){
            if (fellowTownsman[i][0] == 1){
                rs.add(fellowTownsman[i][1]);
            }
            if (fellowTownsman[i][1] == 1){
                rs.add(fellowTownsman[i][0]);
            }
        }
        if (rs.size() == 0){
            return 0;
        }
        int start = rs.size();
        int end = 0;
        while (start != end){
            start = rs.size();
            int[] fellow = new int[start];
            int i = 0;
            for (Integer a : rs){
                fellow[i] = a;
                i++;
            }

            for (int j = 0; j < start; j++){
                for (i = 0; i < fellowTownsman.length; i++){
                    if (fellowTownsman[i][0] == fellow[j]){
                        if (fellowTownsman[i][1] != 1)
                            rs.add(fellowTownsman[i][1]);
                    }
                    if (fellowTownsman[i][1] == fellow[j]){
                        if (fellowTownsman[i][0] != 1)
                            rs.add(fellowTownsman[i][0]);
                    }
                }
            }
            end = rs.size();
        }
        return rs.size();
    }
}
