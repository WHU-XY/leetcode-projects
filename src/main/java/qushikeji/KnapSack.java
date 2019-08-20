package qushikeji;

import java.util.Arrays;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/9 10:50
 */
public class KnapSack {
    public static void main(String[] args) {
        int[][] B = new int[6][21];
        int[] W = {0,2,3,4,5,9};
        int[] V = {0,3,4,5,8,10};

        for (int k = 1; k < 6; k++){
            for (int c = 1; c < 21; c++){
                if (W[k] > c){
                    B[k][c] = B[k-1][c];
                }else {
                    int value1 = B[k-1][c-W[k]] + V[k];
                    int value2 = B[k-1][c];
                    B[k][c] = Math.max(value1, value2);
                }
            }
        }
        for (int i = 0; i < 6; i++){
            System.out.println(Arrays.toString(B[i]));
        }
    }
}
