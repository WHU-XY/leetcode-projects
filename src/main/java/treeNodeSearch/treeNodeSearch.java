package treeNodeSearch;

public class treeNodeSearch {
    //通过前序遍历查找
    public TreeNode search(TreeNode root, int target){
        TreeNode node = null;
        if (root != null){
            if (root.val == target){
                return root;
            }
        }
        if (root.left != null){
            node = search(root.left, target);
            if (node != null){
                return node;
            }
        }
        if (root.right != null){
            node = search(root.right,target);
            if (node != null){
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(new treeNodeSearch().search(root,8).val);
    }
}
