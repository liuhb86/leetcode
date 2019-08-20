/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def maxLevelSum(root: TreeNode): Int = {
        assert(root != null)
        var cur = List(root)
        var ms = root.value
        var ml = 1
        var level = 0
        while (cur.nonEmpty) {
            level += 1
            var s = 0
            var next : List[TreeNode] = Nil
            for (n<-cur) {
                s += n.value
                if (n.left!= null) next = n.left :: next
                if (n.right != null) next = n.right :: next
            }
            if (s > ms) {ms = s; ml = level}
            cur = next
        }
        ml
    }
}