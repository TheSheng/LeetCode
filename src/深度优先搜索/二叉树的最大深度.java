package 深度优先搜索;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName： 二叉树的最大深度
 * @description:
 * @author: lisheng
 * @create: 2020-03-05 08:35
 **/
public class 二叉树的最大深度 {
     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //BFS
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair<TreeNode,Integer>> queue=new LinkedList<>();
        int finalDeep=0;
        queue.add(new Pair<>(root,1));
        while (!queue.isEmpty()){
            Pair<TreeNode, Integer> poll = queue.poll();
            TreeNode key = poll.getKey();
            Integer deep = poll.getValue();
            finalDeep=Math.max(finalDeep,deep);
            int nextDeep=deep+1;
            if(key.left!=null)queue.add(new Pair<>(key.left,nextDeep));
            if(key.right!=null)queue.add(new Pair<>(key.right,nextDeep));
        }
        return  finalDeep;
    }
    //DFS
    public  int maxDepthDFS(TreeNode root){
         if(root==null)return 0;
         int leftDeep=maxDepthDFS(root.left);
         int right=maxDepthDFS(root.right);
         return Math.max(leftDeep,right)+1;
    }
}
