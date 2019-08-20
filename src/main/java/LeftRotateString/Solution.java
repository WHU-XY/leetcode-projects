package LeftRotateString;

public class Solution {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0) return "";
        n = n % len;
        str += str;
        return str.substring(n, n+len);
    }
}
