package code.BFS;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：levelOrder
 * 类 描 述：TODO 力扣题102 二叉树的层序遍历
 * 创建时间：2022/12/2 下午8:27
 * 创 建 人：chenweihua
 */
public class levelOrder {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();


        if (root!=null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0;i<n;++i){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;

    }
}
