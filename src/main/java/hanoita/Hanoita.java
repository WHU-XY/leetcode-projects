package hanoita;

public class Hanoita {
    public static void main(String[] args) {
        hanoita(3,'A','B','C');
    }

    /**
     * @param n 共有N个盘子
     * @param from 开始的柱子
     * @param in 中间的柱子
     * @param to 目标柱子
     * 无论有多少个盘子，都能认为只有两个。上面的所有盘子和最下面一个盘子
     * */
    public static void hanoita(int n, char from, char in, char to){
        if (n ==1){
            System.out.println("将"+n+"从"+from+"移到"+to);
        }else {
            hanoita(n-1,from,to,in);
            System.out.println("将"+n+"从"+from+"移到"+to);
            hanoita(n-1,in,from,to);
        }
    }
}
