/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def rangeSumBST(root: TreeNode, L: Int, R: Int): Int = {
        if (root == null) return 0
        var sum = 0
        if (root.value >=L && root.value <=R) sum +=root.value
        if (L<root.value) sum+= rangeSumBST(root.left, L, R)
        if (R>root.value) sum+= rangeSumBST(root.right, L, R)
        sum
    }
}