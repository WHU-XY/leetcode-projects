package graph;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 14:51
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] vertexs = new String[n];
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++){
            vertexs[i] = "V"+i;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                int weight = sc.nextInt();
                adjacencyMatrix[i][j] = weight;
            }
        }
        sc.close();
        Graph graph = new Graph(vertexs, adjacencyMatrix);
    }
}
