/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def getMinimumDifference(root: TreeNode): Int = {
        solve(root)._3.get
    }
    
    def solve(root: TreeNode) : (Int, Int, Option[Int]) = {
        if (root.left == null && root.right == null) return (root.value, root.value, None)
        val t = new scala.collection.mutable.ArrayBuffer[Int](4)
        var lb = root.value
        var rb = root.value
        if (root.left != null) {
            val (l, r, m) = solve(root.left)
            lb = l
            t += (root.value - r)
            if (m.isDefined) t+= m.get
        }
        if (root.right != null) {
            val (l,r, m) = solve(root.right)
            rb = r
            t += (l - root.value)
            if (m.isDefined) t+= m.get
        }
        //println(s"${root.value} $lb $rb ${t.min}")
        (lb, rb, Some(t.min))
    }
}