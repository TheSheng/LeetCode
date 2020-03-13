package 树;

/**
 * @ClassName： 二叉树的直径
 * @description:
 * @author: lisheng
 * @create: 2020-03-10 08:31
 **/
public class 二叉树的直径{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static  int max;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        int deepLeft = 0;
          if(root.left!=null)deepLeft=getDeep(root.left);
        int deepRight =0;
          if(root.right!=null)deepRight=getDeep(root.right);
        max=Math.max(max,deepLeft+deepRight);
        return max;
    }
    //求这个节点的最大深度
    public  static  int getDeep(TreeNode root){
        int leftDeep=0;
        int rightDeep=0;
        if(root.left!=null) leftDeep=getDeep(root.left);
        if(root.right!=null)rightDeep=getDeep(root.right);
        max=Math.max(max,leftDeep+rightDeep);
        return Math.max(leftDeep,rightDeep)+1;
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
//        TreeNode treeNode2=new TreeNode(2);
//        TreeNode treeNode3=new TreeNode(3);
//        TreeNode treeNode4=new TreeNode(4);
//        TreeNode treeNode5=new TreeNode(5);
//        treeNode.left=treeNode2;
//        treeNode.right=treeNode3;
//        treeNode2.left=treeNode4;
//        treeNode2.right=treeNode5;
        int i = diameterOfBinaryTree(treeNode);
        System.out.println(i);


    }

}

