package pdd;

public class BackTrack {
    public static void main(String[] args) throws Exception{
        //等待求解的全排列集合
        char[]num = new char[]{'A','B','C','D'};
        backtrack(num,0,num.length,new char[num.length],new boolean[num.length]);
    }

    static void backtrack(char[] num,int k,int n,char[] temp,boolean[] hash)
    {
        if(k == n)
        {
            System.out.println(temp);
            return;
        }
        for (int i = 0;i < num.length;i++)
            //如果不在候选答案向量中则添加该字母
            if( !hash[i] )
            {
                hash[i] = true;
                temp[k] = num[i];
                backtrack(num,k+1,n,temp,hash);
                //下一个for循环的时候就是放该层的
                // 下一个可以放的字母，这轮循环放的是这个字母
                //那么下一轮循环显然放的不是这个字母了，那么这个字母需要被
                //移除出hash表
                //temp[i] = ' ';
                hash[i] = false;
            }
    }
}
