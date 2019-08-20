package acmcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 17:00
 */
public class E27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < bArray.length; i++){
            if (hashMap.containsKey(bArray[i])){
                hashMap.put(bArray[i],hashMap.get(bArray[i])+1);
            }else {
                hashMap.put(bArray[i],1);
            }
        }
    }
}
