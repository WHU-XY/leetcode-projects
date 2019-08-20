package pdd;

import java.util.*;

public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Task[] t = new Task[n];
        for (int i = 0; i < n ; i++){
            t[i] = new Task(i+1, sc.nextInt());
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] indegree = new int[n];
        for(int i = 0; i < m; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(graph.containsKey(u)) {
                graph.get(u).add(v);
            } else {
                List<Integer> edges = new ArrayList<>();
                edges.add(v);
                graph.put(u, edges);
            }
            indegree[v-1]++;
        }
        sc.close();


        PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return (o1.weight - o2.weight);
            }
        });

        for(int i = 0; i < n; ++i) {
            if(indegree[i] == 0) queue.offer(t[i]);
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            Task complete = queue.poll();
            res.add(complete.seq);
            if(graph.containsKey(complete.seq)) {
                for(int i : graph.get(complete.seq)){
                    if(--indegree[i-1] == 0) {
                        queue.offer(t[i-1]);
                    }
                }
            }
        }
        for(int i = 0; i < n; ++i) {
            System.out.print(res.get(i));
            if(i != n-1) System.out.print(" ");
        }
    }

    static class Task {
        int seq;
        int weight;
        public Task(int n, int w) {
            seq = n;
            weight = w;
        }
    }
}
