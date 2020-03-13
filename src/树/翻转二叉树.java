package 树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName： 翻转二叉树
 * @description:
 * @author: lisheng
 * @create: 2020-03-04 16:01
 **/
public class 翻转二叉树 {
    class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     }

     //没必要做这些判断 只要有左右节点就递归 不行就会返回null
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.right != null && (root.right.right != null || root.right.left != null)) {
            invertTree(root.right);
        }
        if (root.left != null && (root.left.left != null || root.left.right != null)) {
            invertTree(root.left);

        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        return root;

    }
    //深度优先搜索 一次性访问多条的叫深度优先 实现为队列
    public  TreeNode inverTreeByItear(TreeNode root){
        if(root==null)return root;
        Queue<TreeNode> pool=new LinkedList<>();
        pool.add(root);
        while (!pool.isEmpty()){
            TreeNode thisNode = pool.poll();
            TreeNode left = thisNode.left;
            thisNode.left=thisNode.right;
            thisNode.right=left;
            if(thisNode.left!=null)pool.add(thisNode.left);
            if(thisNode.right!=null)pool.add(thisNode.right);

        }
        return root;
    }
          //标准答案  其实是广度优先 实现是栈或递归
          public TreeNode invertTree1(TreeNode root) {
        //跳出
              if(root==null) return null;
              root.right=invertTree1(root.right);

              root.left=invertTree1(root.left);

              TreeNode right=root.right;
              root.right=root.left;
              root.left=right;
              return  root;
          }

}
