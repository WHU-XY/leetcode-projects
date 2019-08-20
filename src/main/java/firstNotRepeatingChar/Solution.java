package firstNotRepeatingChar;

import java.util.HashMap;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0)
            return -1;
        int index = -1;
        HashMap<Character,Integer> charMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            if (charMap.containsKey(str.charAt(i))){
                int time = charMap.get(str.charAt(i));
                charMap.put(str.charAt(i),++time);
            }else {
                charMap.put(str.charAt(i),1);
            }
        }
        for (int i = 0; i < str.length(); i++){
            if (charMap.get(str.charAt(i)) == 1){
                index = i;
                break;
            }
        }
        return index;
    }
}
