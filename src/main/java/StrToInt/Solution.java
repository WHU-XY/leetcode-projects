package StrToInt;

public class Solution {
    public int StrToInt(String str){
        int start = 0;
        boolean symbol = true; //true --> +;  false --> -;
        int result = 0;
        if (str == null || str.equals(""))
            return 0;
        char[] strChar = str.toCharArray();
        if(strChar[0] == '-'){
            start = 1;
            symbol = false;
        }
        if (strChar[0] == '+'){
            start = 1;
        }
        for (int i = start; i < strChar.length; i++){
            if ((strChar[i]<'0') || (strChar[i] > '9')){
                return 0;
            }
            result = result * 10 + (strChar[i] - '0');
        }
        return symbol ? result : (-1)*result;
    }
}
