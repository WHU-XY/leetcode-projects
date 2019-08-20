package pdd;

import java.util.Map;

public class OPT {
    public static int rec_opt(int[] arr, int cur){
        if (cur == 0){
            return arr[0];
        }else if (cur == 1){
            return Math.max(arr[0], arr[1]);
        }else {
            int a = rec_opt(arr,cur - 2) + arr[cur];
            int b = rec_opt(arr, cur - 1);
            return Math.max(a, b);
        }
    }
    public static int dp_opt(int[] arr, int cur){
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++){
            int a = opt[i -2] + arr[i];
            int b = opt[i -1];
            opt[i] = Math.max(a, b);
        }
        return opt[cur];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,1,7,8,3};
        System.out.println(rec_opt(arr, arr.length-1));
        System.out.println(dp_opt(arr, arr.length-1));
    }
}
