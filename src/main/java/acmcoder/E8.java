package acmcoder;

import java.util.*;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 21:04
 */
public class E8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(a);
            map.put(a, b);
        }
        sc.close();
        Collections.sort(list);
        for (int i = 0; i < list.size()-1; i++){
            int as = list.get(i);
            int ae = map.get(as);
            int bs = list.get(i+1);
            int be = map.get(bs);
            if (bs < ae){
                map.remove(as);
                map.remove(bs);
                list.remove(i+1);
                map.put(as,be);
            }
        }
        int result = m+1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            result -= (entry.getValue() - entry.getKey() + 1);
        }
        System.out.println(result);
    }
}
