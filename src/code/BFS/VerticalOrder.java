package code.BFS;

import java.util.*;

/**
 * 项目名称：leetcodeDemo
 * 类 名 称：VerticalOrder
 * 类 描 述：TODO 力扣题314
 * 创建时间：2022/12/3 下午11:10
 * 创 建 人：chenweihua
 */
public class VerticalOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> res = new TreeMap<>();
        Map<TreeNode, Integer> nodeMap = new HashMap<>();
        nodeMap.put(root, 0);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            int i = nodeMap.get(node);
            //判断一个map中是否存在这个key，如果存在则处理value的数据，如果不存在，则创建一个满足value要求的数据结构放到value中
            res.computeIfAbsent(i, key -> new ArrayList<>()).add(node.val);
            if (node.left != null) {
                deque.offer(node.left);
                nodeMap.put(node.left, i - 1);
            }
            if (node.right != null) {
                deque.offer(node.right);
                nodeMap.put(node.right, i + 1);
            }
        }
        return new ArrayList<>(res.values());
    }
}
