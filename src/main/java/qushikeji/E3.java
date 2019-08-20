package qushikeji;

import java.util.*;

/**
 * @author xieyao
 * @email xieyao@whu.edu.cn
 * @date 2019/8/8 21:06
 */
public class E3 {
    public static void main(String[] args) {
        String s = "can you or canot you yes or no ha hahah";
        Map<Character,Integer> map = new HashMap<>();
        TreeSet<TreeNode> list = new TreeSet<>();
        charStastic(map, s);
        for (Map.Entry entry : map.entrySet()){
            TreeNode temp = new TreeNode((char)entry.getKey(), (int)entry.getValue());
            list.add(temp);
        }
        TreeNode root = toConstruct(list);
        Map<Character, String> codeMap = new HashMap<>();
        getCodeMap(codeMap, root);
        for (Map.Entry entry : codeMap.entrySet()){
            System.out.println("Key: "+entry.getKey()+" Value："+entry.getValue());
        }
        System.out.println(getByteString(s));
        System.out.println(getHuffmanCodeString(codeMap,s));
    }

    public static class TreeNode implements Comparable<TreeNode>{
        char data;
        int time;
        TreeNode leftNode;
        TreeNode rigthtNode;
        public TreeNode(char data, int time){
            this.data = data;
            this.time = time;
        }

        @Override
        public int compareTo(TreeNode o) {
            return (this.time - o.time) > 0 ? 1 : -1;
        }
    }

    public static void charStastic(Map<Character,Integer> map, String s){
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.get(c) != null){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
    }

    public static TreeNode toConstruct(TreeSet<TreeNode> list){
        TreeNode root = null;
        while (list.size() > 1){
            TreeNode temp1 = list.pollFirst();
            TreeNode temp2 = list.pollFirst();
            root = new TreeNode((char) 0, (temp1.time+temp2.time));
            root.leftNode = temp1;
            root.rigthtNode = temp2;
            list.add(root);
        }
        return root;
    }

    public static String getByteString(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            sb.append(Integer.toBinaryString(c));
        }
        return sb.toString();
    }

    public static void getCodeMap(Map<Character, String> codeMap, TreeNode node){

        recursiveInOrder(codeMap, node, "");
    }

    public static void recursiveInOrder(Map<Character, String> codeMap, TreeNode node, String s){
        if (node.leftNode == null && node.rigthtNode ==null){
            char c = node.data;
            codeMap.put(c, s);
            return;
        }
        if (node.leftNode != null){
            recursiveInOrder(codeMap, node.leftNode, s+"0");
        }
        if (node.rigthtNode != null) {
            recursiveInOrder(codeMap, node.rigthtNode, s+'1');
        }
    }

    public static String getHuffmanCodeString(Map<Character, String> codeMap, String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c= s.charAt(i);
            sb.append(codeMap.get(c));
        }
        return sb.toString();
    }
}
