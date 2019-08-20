package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 14:46
 */
public class Dijkstra {
    Graph graph;
    int start;//起点
    ArrayList<String>[] lists;
    public Dijkstra(Graph graph, int start){
        this.graph = graph;
        this.start = start;
    }

    public ArrayList<String>[] getShortestLength(){
        int n = graph.vertexs.length-1;
        Map<String,Integer> map = new TreeMap<>();
        Map<String,ArrayList<String>> spotMap = new HashMap<>();
        for (int i = 0; i <= n; i++){
            if (i != start){
                if (graph.adjacencyMatrix[start][i] == 0){
                    map.put(graph.vertexs[i], Integer.MAX_VALUE/2);
                }else {
                    map.put(graph.vertexs[i], graph.adjacencyMatrix[start][i]);
                    ArrayList<String> list = new ArrayList<>();
                    list.add(graph.vertexs[i]);
                    spotMap.put(graph.vertexs[i], list);
                }
            }
        }
        int i = 0;
        while (i <= n){
            Map.Entry<String, Integer> entry = ((TreeMap<String, Integer>) map).pollFirstEntry();
            String vertex = entry.getKey();
        }

        return lists;
    }
}
