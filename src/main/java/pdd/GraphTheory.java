package pdd;

import java.util.*;

public class GraphTheory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++){
            tasks[i] = new Task(i+1, sc.nextInt());
        }
        //根据依赖关系构建图：入度indegree（图中以v为终点的个数）、以u为起点的边
        int[] indegree = new int[n];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++){
            int u = sc.nextInt(); //图一条边的起点
            int v = sc.nextInt(); //图对应边的终点
            if (graph.containsKey(u)){
               graph.get(u).add(v);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                graph.put(u, list);
            }
            indegree[v-1]++;
        }
        sc.close();
        //优先队列，权重小的先出
        Queue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return (o1.weight - o2.weight);
            }
        });

        //入度为0的任务先入队列
        for (int i = 0; i < n; i++){
            if (indegree[i] == 0){
                queue.offer(tasks[i]);
            }
        }

        //结果
        List<Integer> result = new ArrayList<>();

        while(queue.size() != 0){
            Task complete = queue.poll();
            result.add(complete.num);
            if (graph.containsKey(complete.num)){
                for (int i : graph.get(complete.num)){
                    if(--indegree[i -1] == 0){
                        queue.offer(tasks[i-1]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++){
            System.out.print(result.get(i));
            if (i != (n-1))
                System.out.print(" ");
        }
        System.out.println();
    }
    private static class Task{
        private int num;
        private int weight;

        public Task(int num, int weight){
            this.num = num;
            this.weight = weight;
        }

    }
}
