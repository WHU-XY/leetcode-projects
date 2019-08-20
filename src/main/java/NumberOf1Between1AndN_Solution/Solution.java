package NumberOf1Between1AndN_Solution;

public class Solution {
    public static void main(String[] args) {
        int n =13;
        int times=0;
        StringBuffer sn=new StringBuffer();
        for(int i=1;i<=n;i++){
            sn.append(i);
        }

        for(int i=0;i<sn.length();i++){
            if(sn.charAt(i) == '1'){
                times++;
            }
        }
        //return times;
        System.out.println(times);
    }
}
