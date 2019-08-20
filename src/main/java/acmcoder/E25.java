package acmcoder;

import java.util.*;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/11 16:34
 */
public class E25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String[] sArray = s.split(" ");
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < sArray.length; i++){
                if (hashMap.containsKey(sArray[i])){
                    hashMap.put(sArray[i],hashMap.get(sArray[i])+1);
                }else {
                    hashMap.put(sArray[i],1);
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (Map.Entry<String,Integer> entry : hashMap.entrySet()){
                list.add(entry.getValue());
            }
            Collections.sort(list);
            for (Integer t : list){
                System.out.print(t+" ");
            }
            System.out.println();
        }
    }
}
