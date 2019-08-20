package pdd;

import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sArray = sc.nextLine().split(" ");
        System.out.println(backtrack(sArray, 0, sArray.length, new String[sArray.length], new boolean[sArray.length], false));
//        char[] num = new char[]{'A','B','C','D','E'};
//        backtrack(num, 0, num.length, new char[num.length], new boolean[num.length]);
    }
    /*
    * num 需要排列的数组
    * k 正在排第k个
    * n 需要排列数组的长度
    * temp 排列好的数组
    * isUsed 是否排列过
    * */
    private static void backtrack(char[] num, int k, int n, char[] temp, boolean[] isUsed){
        if (k == n){
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < n; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                temp[k] = num[i];
                backtrack(num, k+1, n, temp, isUsed);
                isUsed[i] = false;
            }
        }
    }

    private static boolean backtrack(String[] sArray, int k, int n, String[] temp, boolean[] isUsed, boolean flag){
        if (k == n){

            return check(temp);
        }
        for (int i = 0; i < n; i++){
            if (!isUsed[i]){
                isUsed[i] = true;
                temp[k] = sArray[i];
                if(backtrack(sArray, k+1, n, temp, isUsed, flag)){
                    flag = true;
                    break;
                }
                isUsed[i] = false;
            }
        }
        return flag;
    }
    private static boolean check(String[] temp){
        for (int i = 0; i < (temp.length - 1); i++){
            if (i == 0){
                if (temp[i].charAt(0) != temp[temp.length -1].charAt(temp[temp.length -1].length() -1)
                        || temp[i].charAt(temp[i].length() -1) != temp[i+1].charAt(0))
                    return false;
            }else {
                if (temp[i].charAt(temp[i].length() -1) != temp[i+1].charAt(0))
                    return false;
            }
        }
        return true;
    }
}
