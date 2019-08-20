package intToRoman;

public class Solution {

    static String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<13; i++){
            while(num>=value[i]){
                num -= value[i];
                res.append(str[i]);
            }
        }
        return res.toString();
    }
}
