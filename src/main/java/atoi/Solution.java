package atoi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 去除前面的空格
        int start = 0;
        while(str.charAt(start) == ' ')
            start++;
        long res = 0;
        boolean positive = true;
        if (str.charAt(start) == '-') {
            positive = false;
            start++;
        } else if (str.charAt(start) == '+'){
            start++;
        }

        for (int j = start; j < str.length(); j++) {
            if (str.charAt(j) == ' ' || str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }

            res = res * 10 + (str.charAt(j) - '0');


            if (!positive && -res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if (positive && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        if (positive == false) {
            res = -res;
        }

        return (int) res;
    }
}
