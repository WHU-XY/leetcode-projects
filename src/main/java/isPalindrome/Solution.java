package isPalindrome;

public class Solution {
    public boolean isPalindrome(int x) {
        // 小于0， 直接返回
        if (x < 0) {
            return false;
        }
        String valueStr = String.valueOf(x);
        int length = valueStr.length();
        int i = 0;
        boolean result = true;
        while (i < length / 2) {
            if (valueStr.charAt(i) != valueStr.charAt(length - i - 1)) {
                result = false;
                // 如果有一个不相同就跳出循环
                break;
            }
            i++;
        }
        return result;
    }
}
