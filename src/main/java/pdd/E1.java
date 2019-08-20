package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] aStrings = sc.nextLine().split(" ");
        String[] bStrings = sc.nextLine().split(" ");
        sc.close();
        int aLength = aStrings.length;
        int bLength = bStrings.length;
        int[] a = new int[aLength];
        int[] b = new int[bLength];
        for (int i = 0; i < aLength; i++){
            a[i] = Integer.valueOf(aStrings[i]);
        }
        for (int i = 0; i < bLength; i++){
            b[i] = Integer.valueOf(bStrings[i]);
        }
        int cur = 0;
        for (; cur < aLength-1; cur++){
            if (a[cur] > a[cur+1])
                break;
        }
        //l1,l2,r1,r2四个数字
        int l1 = (cur == 0)? Integer.MIN_VALUE : a[cur-1];
        int l2 = a[cur]; //l2 >= r1
        int r1 = a[cur+1];
        int r2 = (cur == (aLength-2))? Integer.MAX_VALUE : a[cur+2];
        Arrays.sort(b);

        for (int i = bLength-1; i >= 0; i--){
            if (b[i] > l2 && b[i] < r2){
                a[cur+1] = b[i];
                break;
            }else if(b[i] > l1 && b[i] < r1){
                a[cur] = b[i];
                break;
            }
        }
        if (a[cur] >= a[cur+1]){
            System.out.println("NO");
        }else {
            for (int i = 0; i < a.length; i++){
                System.out.print(a[i]);
                if(i != a.length -1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
