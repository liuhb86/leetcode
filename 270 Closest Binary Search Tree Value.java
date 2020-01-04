/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        TreeNode node = root;
        while(node != null) {
            if (node.val == target) return node.val;
            if (Math.abs(node.val - target) < Math.abs(result - target)) {
                result = node.val;
            }
            if (node.val < target) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return result;
    }
}