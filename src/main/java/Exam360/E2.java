package Exam360;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/16 9:29
 */
public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for (int j = 0; j < n; j++){
            listA.add(sc.nextInt());
        }
        for (int j = 0; j < n; j++){
            listB.add(sc.nextInt());
        }
        sc.close();
//        Map<Integer,Integer> mapA = new HashMap<>();
//        Map<Integer,Integer> mapB = new HashMap<>();
//        for (int j = 0; j < n; j++){
//            if (mapA.containsKey(a[0][j])){
//                mapA.put(a[0][j],mapA.get(a[0][j])+1);
//            }else {
//                mapA.put(a[0][j],1);
//            }
//        }
//        for (int j = 0; j < n; j++){
//            if (mapB.containsKey(a[1][j])){
//                mapB.put(a[1][j],mapB.get(a[1][j])+1);
//            }else {
//                mapB.put(a[1][j],1);
//            }
//        }
        ArrayList<Integer> result = new ArrayList<>();
        int i = 4;
        while (i >= 0){
//            while (listA.size()>0){
//                 int temp = listA.get(0);
//                 if(listB.contains(i-temp)){
//                     result.add(i);
//                     listA.remove(new Integer(temp));
//                     listB.remove(new Integer(i-temp));
//                 }
//            }
        }


    }
}
