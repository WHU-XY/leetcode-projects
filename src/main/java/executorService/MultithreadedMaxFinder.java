package executorService;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/8 10:12
 */
public class MultithreadedMaxFinder {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++){
            data[i] = sc.nextInt();
        }
        sc.close();
        FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
        FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        System.out.println(Math.max(future1.get(), future2.get()));
        service.shutdown();

    }
}
