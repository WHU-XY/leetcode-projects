package pdd;

import java.util.Arrays;

public class Fib {
    public static void main(String[] args) {
        int[] fib = new int[10];
        for (int i = 0; i < 10; i++){
            if (i == 0 || i == 1)
                fib[i] = 1;
            else
                fib[i] = fib[i-1]+fib[i-2];
        }
        System.out.println(Arrays.toString(fib));
    }
}
