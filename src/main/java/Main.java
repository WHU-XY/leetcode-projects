import javax.sound.midi.Soundbank;
import java.util.*;
public class Main{
    public static void main(String[] args){
        System.out.println(Runtime.getRuntime().availableProcessors());
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(arr);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tm = sc.nextInt();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            Task t = new Task();
            t.v = sc.nextInt();
            t.l = sc.nextInt();
            t.c = sc.nextInt();
            tasks[i] = t;
        }
        Arrays.sort(tasks);
        System.out.println(Arrays.toString(tasks));
        int ls = 0;
        for (int i = 0; i < n; i++) {
            if (tm < tasks[i].v) {
                break;
            }
            if (tm > tasks[i].v * tasks[i].c) {
                ls += tasks[i].l * tasks[i].c;
                tm -= tasks[i].v * tasks[i].c;
            } else {
                ls += tm / tasks[i].v * tasks[i].l;
                tm -= tm / tasks[i].v * tasks[i].v;
            }
        }
        System.out.println(ls);
    }
    private static class Task implements Comparable<Task>{
        int v;
        int l;
        int c;

        @Override
        public int compareTo(Task o) {
            return (this.l*1.0/this.v - o.l*1.0/o.v)>0 ? -1:1 ;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "v=" + v +
                    ", l=" + l +
                    ", c=" + c +
                    '}';
        }
    }

    private static void maxSubArray(int[] arr){
        int ans = arr[0];
        //int sum = 0;
        int[] opt = new int[arr.length];
        int[][] coordinates = new int[arr.length][2];
//        for (int a : arr){
//            if(sum > 0) {
//                sum += a;
//            } else {
//                sum = a;
//            }
//            ans = Math.max(ans, sum);
//        }
        for (int i = 0; i < arr.length; i++){
            if (i == 0){
                opt[i] = arr[i];
                coordinates[i][0] = i;
                coordinates[i][1] = i;
            }else {
                int a = opt[i-1]+arr[i];//继续
                int b = arr[i];         //重新开始
                if (a >= b){
                    coordinates[i][0] = coordinates[i-1][0];
                    coordinates[i][1] = i;
                    opt[i] = a;
                }else {
                    coordinates[i][0] = i;
                    coordinates[i][1] = i;
                    opt[i] = b;
                }
                ans = Math.max(opt[i], ans);
            }
        }
        int cur = 0;
        int start = 0;
        int end = 0;
        for (;cur < arr.length; cur++){
            if (ans == opt[cur]){
                start = coordinates[cur][0];
                end = coordinates[cur][1];
            }
        }
        System.out.println(Arrays.toString(opt));
        System.out.println("最大子序列和为："+ans+" 起始坐标为："+start+" 结束坐标为："+end);
        //return ans;
    }
}
