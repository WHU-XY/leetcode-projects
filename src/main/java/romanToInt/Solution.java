package romanToInt;

import java.util.HashMap;

public class Solution {

    public int romanToInt(String s) {
        if("".equals(s) || null == s) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int value = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if(i == chars.length -1){
                value += map.get(chars[i]);
            }else{
                Integer left = map.get(chars[i]);
                Integer right = map.get(chars[i + 1]);
                if(left >= right){
                    value += left;
                }else{
                    value += (right -left);
                    i++;
                }
            }
        }

        return value;
    }
}
