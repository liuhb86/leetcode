/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def constructFromPrePost(pre: Array[Int], post: Array[Int]): TreeNode = {
        if (pre.length == 0) return null
        val node = new TreeNode(pre(0))
        if (pre.length == 1) return node
        val leftSize = post.indexOf(pre(1)) + 1
        node.left = constructFromPrePost(pre.slice(1, leftSize + 1), post.take(leftSize))
        node.right = constructFromPrePost(pre.drop(leftSize + 1), post.slice(leftSize , post.length - 1))
        node
    }
}