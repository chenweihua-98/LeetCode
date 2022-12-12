package code.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：ZigzagLevelOrder
 * 类 描 述：TODO 力扣题103
 * 创建时间：2022/12/2 下午9:50
 * 创 建 人：chenweihua
 */
public class ZigzagLevelOrder {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res =new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        Boolean leftToRight = true;

        if(root!=null){
            queue.offer(root);
        }else {
            return res;
        }

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i =0;i<n;++i) {
                TreeNode node = queue.poll();
                if (leftToRight){
                    list.add(node.val);
                }else{
                    list.add(0,node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(list);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
