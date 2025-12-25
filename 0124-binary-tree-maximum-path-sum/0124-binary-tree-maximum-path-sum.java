/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{root.val};
        recursion(root, result);
        return result[0];
    }

    private int recursion(TreeNode root, int[] globalResult) {
        // base case
        if (root.left == null && root.right == null) {
            // update global result, if possible
            globalResult[0] = Math.max(globalResult[0], root.val);
            return root.val;
        }

        int localResult = root.val;

        // subproblems & recursion rule
        int leftResult = 0; // Avoid using the initial value! Ensure we update them before calling.
        int rightResult = 0;

        if (root.left != null) {
            leftResult = recursion(root.left, globalResult);
            localResult = Math.max(localResult, leftResult + root.val);
        }
        if (root.right != null) {
            rightResult = recursion(root.right, globalResult);
            localResult = Math.max(localResult, rightResult + root.val);
        }

        /** update global result, if possible **/
        // Case 1: Take a single path (left -> root; right -> root)
        globalResult[0] = Math.max(globalResult[0], localResult);
        
        // Case 2: Take both paths (left -> root -> right)
        if (root.left != null && root.right != null) {
            globalResult[0] = Math.max(globalResult[0], leftResult + root.val + rightResult);
        }

        return localResult;
    }
}