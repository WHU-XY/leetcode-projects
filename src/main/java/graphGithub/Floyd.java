package graphGithub;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/10 14:46
 */
public class Floyd {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0,6,Integer.MAX_VALUE,4},
                {5,0,1,Integer.MAX_VALUE},
                {3,Integer.MAX_VALUE,0,2},
                {8,2,Integer.MAX_VALUE,0}};
        int[][] path = new int[][]{
                {-1,-1,-1,-1},
                {-1,-1,-1,-1},
                {-1,-1,-1,-1},
                {-1,-1,-1,-1}};
        for (int k = 0; k < 4; k++){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (a[i][j] > (a[i][k]+a[k][j])){
                        a[i][j] = a[i][k] + a[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
        printPath(0,1,path);
    }
    public static void printPath(int u, int v, int[][] path){
        System.out.print(u+"->");
        while (path[u][v] != -1){
            System.out.print(path[u][v]+"->");
            u = path[u][v];
        }
        System.out.println(v);
    }
}
