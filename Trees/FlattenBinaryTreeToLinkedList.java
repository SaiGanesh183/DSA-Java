package Trees;

  class TreeNode {
    int val;
   TreeNode left;
   TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class FlattenBinaryTreeToLinkedList {
    public TreeNode helper(TreeNode root, TreeNode subroot) {
        if (subroot == null) {
            return root;
        }

        TreeNode left = subroot.left;
        TreeNode right = subroot.right;

        root.left = null;
        root.right = subroot;
        root = root.right;

        root = helper(root, left);
        root = helper(root, right);

        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;


        root = helper(root, left);
        root=helper(root, right);
    }
}
