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
    def verticalOrder(root: TreeNode): List[List[Int]] = {
        val r = Map[Int, List[(Int, Int)]]()
        dfs(root, 0, 0, r)
        r.mapValues(_.reverse.sortBy(_._1).map(_._2)).toList.sortBy(_._1).map(_._2)
    }
    
    def dfs(node: TreeNode, x: Int, y: Int, r: Map[Int, List[(Int, Int)]]) {
        if (node == null) return
        r(x) = (y, node.value) :: r.getOrElse(x, Nil)
        dfs(node.left, x-1, y+1, r)
        dfs(node.right, x+1, y+1, r)
    }
}