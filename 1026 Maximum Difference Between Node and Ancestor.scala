/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.math.abs
object Solution {
    def maxAncestorDiff(root: TreeNode): Int = {
        var stack = List(new Frame(root, root.value, root.value))
        var r: Option[Int] = None
        while (stack != Nil) {
            val f = stack.head
            if (f.status==0) {
                if (f.node == null) {
                    r = None
                    stack = stack.tail
                } else {
                    f.status = 1
                    stack = new Frame(f.node.left, f.mn, f.mx) :: stack
                }
            } else if (f.status == 1) {
                if (r.isDefined) f.v = f.v.max(r.get)
                f.status = 2
                stack = new Frame(f.node.right, f.mn, f.mx) :: stack
            } else {
                if (r.isDefined) f.v = f.v.max(r.get)
                r = Some(f.v)
                stack = stack.tail
            }
        }
        r.get
    }
    
    def dfs(node: TreeNode, p: Int) : Int = {
        var v = abs(node.value - p)
        val pc = p.max(node.value)
        if (node.left != null) v = v.max(dfs(node.left, pc))
        if (node.right != null) v = v.max(dfs(node.right, pc))
        v
    }
}

class Frame(val node: TreeNode, _mn: Int, _mx: Int) {
    val nv = if (node == null) 0 else node.value
    val mx = nv.max(_mx)
    val mn = nv.min(_mn)
    var status: Int = 0
    var v = abs(nv - _mx).max(abs(nv - _mn))
}