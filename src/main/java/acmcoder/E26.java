package acmcoder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 16:43
 */
public class E26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] connections = new int[m][3];
            for (int i = 0; i < m; i++){
                connections[i][0] = sc.nextInt();
                connections[i][1] = sc.nextInt();
                connections[i][2] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < m; i++){
                if (connections[i][2] == 0){
                    continue;
                }
                if (connections[i][2] == 1 && connections[i][0] == 1){
                    set.add(connections[i][1]);
                    continue;
                }
                if (connections[i][2] == 1 && connections[i][1] == 1){
                    set.add(connections[i][0]);
                    continue;
                }
            }
            int start = set.size();
            int end = 0;
            while (start != end){
                start = set.size();
                int[] temp = new int[start];
                Iterator<Integer> iterator = set.iterator();
                int i = 0;
                while (iterator.hasNext()){
                    temp[i] = iterator.next();
                    i++;
                }
                for (i = 0; i < start; i++){
                    for (int j = 0; j < m; j++){
                        if (connections[j][2] == 0){
                            continue;
                        }
                        if (connections[j][2] == 1 && connections[j][0] == temp[i] && connections[j][1] != 1){
                            set.add(connections[j][1]);
                            continue;
                        }
                        if (connections[j][2] == 1 && connections[j][1] == temp[i] && connections[j][0] != 1){
                            set.add(connections[j][0]);
                            continue;
                        }
                    }
                }
                end = set.size();
            }
            System.out.println(set.size());
        }
    }
}
