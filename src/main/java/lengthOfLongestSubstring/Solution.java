package lengthOfLongestSubstring;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals(""))
            return 0;
        if(s.length() == 1)
            return 1;
        char[] schar = s.toCharArray();
        int length = schar.length;
        List<Character> list = new ArrayList<>();
        int result = 0;
        for(int i = 0; i < length; i++){
            for(int j = i; j < length; j++){
                if(list.contains(schar[j])){
                    result = Math.max(result, list.size());
                    list.clear();
                    break;
                }
                list.add(schar[j]);
            }
        }
        return result;
    }

    public int lengthOfLongestSubstringNew(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstringNewer(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

    public int lengthOfLongestSubstringMyNew(String s) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int length = s.length();
        List<Character> list = new ArrayList<>();
        while(i < length && j < length){
            if(!list.contains(s.charAt(j))){
                list.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            }else{
                list.remove((Character) s.charAt(i++));
                //list.remove();
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstringMyNewer(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //i = Math.max(map.get(s.charAt(j))+1, i);
                i = map.get(s.charAt(j)) + 1;
            }
            map.put(s.charAt(j), j);
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }
}
