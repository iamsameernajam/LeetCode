class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0; // \U0001f311 Base case

        // \U0001f33f If no left child, recurse only right
        if (root.left == null) return minDepth(root.right) + 1;

        // \U0001f33f If no right child, recurse only left
        if (root.right == null) return minDepth(root.left) + 1;

        // \U0001f343 Both children exist, take the minimum
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}