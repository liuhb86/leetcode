/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def largestValues(root: TreeNode): List[Int] = {
        if (root == null) return Nil
        var q = List(root)
        var r : List[Int] = Nil
        while (q.nonEmpty) {
            var m = q.head.value
            var next : List[TreeNode] = Nil
            for (n <- q) {
                if (n.value > m) m = n.value
                if (n.left != null) next = n.left :: next
                if (n.right != null) next = n.right :: next
            }
            r = m :: r
            q = next
        }
        r.reverse
    }
}