package 广度优先搜索;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName： 对称二叉树
 * @description:
 * @author: lisheng
 * @create: 2020-03-05 09:33
 **/

public class 对称二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
         if(root==null)return  true;
         return  isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null||right==null)return  false;
        return  (left.val==right.val)&&isMirror(left.left,right.right)&&isMirror(left.right,right.left);
    }
    //BFS
    public boolean isSymmetricBFS(TreeNode root) {
        if(root==null)return true;
        Queue<Pair<TreeNode,TreeNode>> queue=new LinkedList<>();
        queue.add(new Pair<>(root.left,root.right));
        while (!queue.isEmpty()){
            Pair<TreeNode, TreeNode> poll = queue.poll();
            TreeNode left = poll.getKey();
            TreeNode right=poll.getValue();
            if(left==null&&right==null)continue;
            if(left==null||right==null)return false;
            if(left.val!=right.val)return false;
            queue.add(new Pair<>(left.left,right.right));
            queue.add(new Pair<>(left.right,right.left));
        }
        return  true;

    }

}
