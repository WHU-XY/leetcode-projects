package acmcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 15:48
 */
public class E24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0){
            int m = sc.nextInt();
            int[] guidedMissiles = new int[m];
            for (int i = 0; i < m; i++){
                guidedMissiles[i] = sc.nextInt();
            }
            System.out.println(getLongestSubString(guidedMissiles));
            n--;
        }
        sc.close();
    }
    public static int getLongestSubString(int[] data){
        int high = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        recursive(high,data,0,0,list);
        Collections.sort(list);
        return list.get(list.size()-1);
    }
    public static void recursive(int high, int[] data, int temp, int start, ArrayList<Integer> list){
        if (start == data.length-1){
            if (high >= data[start]){
                temp++;
                list.add(temp);
                return;
            }else {
                list.add(temp);
                return;
            }
        }
        if (high >= data[start]){
            //选
            recursive(data[start],data,temp+1, start+1,list);
        }
        //不选
        recursive(high,data,temp,start+1,list);
    }
}
