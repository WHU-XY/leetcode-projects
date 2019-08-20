package qushikeji;

import java.util.Scanner;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/8 20:01
 */
public class E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        sc.close();
        String[] a = num1.split("\\.");
        String[] b = num2.split("\\.");

        String[] ad = new String[2];
        String[] bd = new String[2];

        for (int i = 0; i < 2; i++){
            if (i >= a.length){
                ad[i] = "";
            }else {
                ad[i] = a[i];
            }
            if (i >= b.length){
                bd[i] = "";
            }else {
                bd[i] = b[i];
            }
        }
        int max = Math.max(ad[1].length(),bd[1].length());
        ad[1] = toSizeStringEnd(ad[1],max);
        bd[1] = toSizeStringEnd(bd[1],max);
        char[] ax = ad[1].toCharArray();
        char[] bx = bd[1].toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (max > 0){
            int temp = 0;
            int x = ax[max-1]-'0';
            int y = bx[max-1]-'0';
            temp = x + y + carry;
            if (temp >= 10){
                temp -= 10;
                carry = 1;
            }else {
                carry = 0;
            }
            sb.append(temp);
            max--;
        }
        if (sb.length() != 0){
            sb.append(".");
        }
        max = Math.max(ad[0].length(),bd[0].length());
        ad[0] = toSizeStringStart(ad[0],max);
        bd[0] = toSizeStringStart(bd[0],max);
        char[] az = ad[0].toCharArray();
        char[] bz = bd[0].toCharArray();
        while (max > 0){
            int temp = 0;
            int x = az[max-1]-'0';
            int y = bz[max-1]-'0';
            temp = x + y + carry;
            if (temp >= 10){
                temp -= 10;
                carry = 1;
            }else {
                carry = 0;
            }
            sb.append(temp);
            max--;
        }
        if (carry != 0){
            sb.append(carry);
        }
        String temp = sb.reverse().toString();
        System.out.println(temp);
        System.out.println(checkZero(temp));
    }

    public static String toSizeStringEnd(String s, int size){
        StringBuffer sb = new StringBuffer(s);
        for (int i = s.length(); i < size; i++){
            sb.append("0");
        }
        return sb.toString();
    }
    public static String toSizeStringStart(String s, int size){
        StringBuffer sb = new StringBuffer(s);
        for (int i = s.length(); i < size; i++){
            sb.append("0");
        }
        return sb.reverse().toString();
    }
    public static String checkZero(String s){
        int l = s.length();
        int a = s.indexOf(".");
        int b = s.lastIndexOf("0");
        int c = s.indexOf("0");
        //没有小数点只考虑前面可能出现的0
        if (a == -1){
            if (c == 0){
                int i = 0;
                for (char ch : s.toCharArray()){
                    if (ch == '0'){
                        i++;
                    }else {
                        break;
                    }
                }
                s = s.substring(i+1);
                return s;
            }
        }
        if (a != -1){
            if (c == 0){
                int i = 0;
                for (char ch : s.toCharArray()){
                    if (ch == '0'){
                        i++;
                    }else {
                        break;
                    }
                }
                if (i < a){
                    s = s.substring(i+1);
                }else {
                    s = s.substring(a);
                }
                return s;
            }
        }
        if (a != -1){
            if (b == (l-1)){
                char[] ch = s.toCharArray();
                int i = l-1;
                for (;i >= 0; i--){
                    if (ch[i] != '0'){
                        break;
                    }
                }
                if (i >= (a+1)){
                    return s.substring(0,i+1);
                }else {
                    return s.substring(0,i);
                }
            }
        }
        return s;
    }
}
