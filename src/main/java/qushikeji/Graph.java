package qushikeji;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/9 18:15
 */
public class Graph {
    char[] Vexs;//定点表
    int[][] Arcs;//邻接矩阵、边的信息
    /*
    * Arcs[i][j] = 1或者权值 表明 i到j存在边且为 1或权值
    *              0         表明 i到j不存在边
    **/

    /**
     * 获取图中对应顶点下标 有则返回对应下标、无则返回-1
     * @param vex 顶点
     * @return
     */
    public int locateVex(char vex){
        for (int i = 0; i < Vexs.length; i++){
            if (Vexs[i] == vex){
                return i;
            }
        }
        return -1;
    }

    VNode[] vNodes;//顶点数组 头结点

    /**
     * 头结点存放顶点内容
     * 表结点存放相邻点在数组的下标，并且指向其它相邻节点在数组的下标
     */
    public static class VNode{
        char data;
        int index;
        VNode next;

        public VNode(char data,int index){
            this.data = data;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.vNodes = new VNode[5];
    }
    public static void change(int[] a){
        for (int i = 0; i < a.length; i++){
            a[i]++;
        }
    }
    public static void change(Node[] a){
        for (int i = 0; i < a.length; i++){
            Node t = null;
            try {
                t = (Node) a[i].clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            t.data++;
        }

    }
    public static class Node implements Cloneable{
        int data;
        public Node(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            return this.data == ((Node)obj).data;
        }
    }
}
