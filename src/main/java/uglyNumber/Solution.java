package uglyNumber;

import java.util.ArrayList;

public class Solution {
    public int GetUglyNumber_Solution(int index){
        // 0-6的丑数分别为0-6
        if(index < 7) return index;
        //p2，p3，p5分别为三个队列的指针，newNum为从队列头选出来的最小数
        int p2 = 0, p3 = 0, p5 = 0, newNum = 1;
        ArrayList<Integer> arr =new ArrayList<>();
        arr.add(newNum);
        while(arr.size() < index) {
            //选出三个队列头最小的数
            newNum = Math.min(arr.get(p2) * 2, Math.min(arr.get(p3) * 3, arr.get(p5) * 5));
            //这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
            if(arr.get(p2) * 2 == newNum) p2++;
            if(arr.get(p3) * 3 == newNum) p3++;
            if(arr.get(p5) * 5 == newNum) p5++;
            arr.add(newNum);
        }
        return newNum;
    }
}
