package moreThanHalfNum;

import java.util.Arrays;

public class Solution {
    public int MoreThanHalfNumSolutionOne(int[] array) {
        int len=array.length;
        if(len<1){
            return 0;
        }
        int count=0;
        Arrays.sort(array);
        int num=array[len/2];
        for(int i=0;i<len;i++){
            if(num==array[i])
                count++;
        }
        if(count<=(len/2)){
            num=0;
        }
        return num;
    }
    public int MoreThanHalfNumSolutionTwo(int[] array){
        int len=array.length;
        if(len<1){
            return 0;
        }
        int result = array[0];
        int times = 1; // 次数

        for(int i=1;i<len;++i)
        {
            if(times == 0)
            {
                // 更新result的值为当前元素，并置次数为1
                result = array[i];
                times = 1;
            }
            else if(array[i] == result)
            {
                ++times; // 相同则加1
            }
            else
            {
                --times; // 不同则减1
            }
        }

        // 判断result是否符合条件，即出现次数大于数组长度的一半
        times = 0;
        for(int i=0;i<len;++i)
        {
            if(array[i] == result) ++times;
        }

        return (times > len/2) ? result : 0;
    }
}
