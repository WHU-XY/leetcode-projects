package acmcoder;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 13:35
 */
public class E16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        genSnake(n);
    }
    public static void genSnake(int n)
    {
        int max = n * n;
        int totalNum = 1, x = 0, y = 0, xIndex = 1, yIndex = 0;
        int[][] snake = new int[n][n];
        for (; totalNum <= max; totalNum++)
        {
            snake[x][y] = totalNum;
            if (x + xIndex == n || x + xIndex < 0 || y + yIndex == n || y + yIndex < 0
                    || snake[x + xIndex][y + yIndex] != 0)
            {
                if (xIndex == 0)
                {
                    xIndex = -yIndex;
                    yIndex = 0;
                }
                else
                {
                    yIndex = xIndex;
                    xIndex = 0;
                }
            }
            y += yIndex;
            x += xIndex;
        }

        for (int a = 0; a < n; a++)
        {
            for (int b = n - 1; b >= 0; b--)
            {
                System.out.print(snake[a][b] + " ");
            }
            System.out.println();
        }
    }
}
