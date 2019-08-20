package pdd;

public class Main {

    public static void main(String[] args) throws Exception{
        //等待求解的全排列集合
        char[]num = new char[]{'A','B','C'};

        dfs(num,0,num.length,new char[num.length]);
    }

    /**
     * num需要排列的数组
     * k正在排列第k个位置
     * n需要排列数组的下标
     * temp排列后的数组
     */
    public static void dfs(char[] num,int k,int n,char[] temp) {
        if(k == n)
        {
            System.out.println(temp);
            return;
        }
        for(int i = 0; i < n; i++) {
            //每次填充完就判断，如果不合法，则根本不会向下进行!
            temp[k] = num[i];
            if(is_Legal(temp,k+1))
                dfs(num, k + 1, n, temp);
        }
    }

    //cur代表这是第几次填充，第cur次填充对应着填充
    //第cur-1下标的地方，因此上面调用时为下标+1,也就是k+1
    static boolean is_Legal(char[]temp,int cur)
    {
        for(int i = 0;i < cur;i++)
            for(int j = i+1;j < cur;j++)
                if(temp[i] == temp[j])
                    return false;
        return true;
    }

}

