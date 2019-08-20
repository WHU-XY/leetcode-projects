package graph;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 14:46
 */
public class Graph {
    //顶点数组
    String[] vertexs;
    int[][] adjacencyMatrix;

    public Graph(String[] vertexs, int[][] adjacencyMatrix){
        this.vertexs = vertexs;
        this.adjacencyMatrix = adjacencyMatrix;
    }
}
