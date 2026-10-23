package Trees;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class AllNodesDistanceKInBinaryTree {
        public int helper2(TreeNode root, TreeNode target, int k, List<Integer> list) {
        if (root == null) return -1;

        if (root == target) return k - 1;

        int count = helper2(root.left, target, k, list);

        if (count == 0) list.add(root.val);
        if(count!=0) {
            if(root.right!=null) {
            helper1(root.right, count-1, list);
            }
        }
        if (count != -1) return count - 1;
        

        count = helper2(root.right, target, k, list);

        if (count == 0) list.add(root.val);
         if(count!=0) {
            if(root.left!=null) {
            helper1(root.left, count-1, list);
            }
        }
        if (count != -1) return count - 1;

        return -1;
    }

    public void helper1(TreeNode target, int k, List<Integer> list) {
        if (target == null || k < 0) return;

        if (k == 0) {
            list.add(target.val);
            return;
        }

        helper1(target.left, k - 1, list);
        helper1(target.right, k - 1, list);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();

        helper1(target, k, list);
        helper2(root, target, k, list);

        return list;
    }



}
