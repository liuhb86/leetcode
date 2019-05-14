/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.util.matching.Regex
import scala.collection.mutable.ListBuffer
object Solution {
    def recoverFromPreorder(S: String): TreeNode = {
        val stack = new ListBuffer[TreeNode]
        for (g <- raw"(-*)(\d+)".r.findAllMatchIn(S)) {
            val d = g.group(1).length
            val v = g.group(2).toInt
            val node = new TreeNode(v)
            if (d >= stack.size) {
                if (!stack.isEmpty) stack.last.left = node
                stack += node
            } else {
                stack.trimEnd(stack.size - d)
                stack.last.right = node
                stack += node
            }
        }
        stack.head
    }
}