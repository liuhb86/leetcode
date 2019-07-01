/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.collection.mutable.Map
object Solution {
    def pathSum(root: TreeNode, sum: Int): Int = {
        val map = Map(0->1)
        count(root, sum, 0, map)
    }
    
    def count(node: TreeNode, sum: Int, _s: Int, map:Map[Int,Int]) : Int = {
        if (node == null) return 0
        val s = _s + node.value
        var r = map.getOrElse(s-sum, 0)
        val c = map.getOrElse(s,0)
        map(s) =  c + 1
        r += count(node.left, sum, s, map)
        r += count(node.right, sum, s, map)
        if (c >0) map(s)= c else map -= s
        r
    }
}