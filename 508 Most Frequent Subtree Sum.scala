/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */

object Solution {
    def findFrequentTreeSum(root: TreeNode): Array[Int] = {
        val r = new Result()
        dfs(root, r)
        r.r.toArray
    }
    
    def dfs(node: TreeNode, r: Result) : Int = {
        if (node == null) return 0
        val left = dfs(node.left, r)
        val right = dfs(node.right, r)
        val sum = node.value + left + right
        r.put(sum)
        sum
    }
}

class Result{
    var count = 0
    var r : List[Int] = Nil
    val map = scala.collection.mutable.Map[Int, Int]()
    def put(v: Int) {
        val c = map.getOrElse(v, 0) + 1
        map(v) = c
        if (c > count) {
            count = c
            r = List(v)
        } else if ( c==count) {
            r = v :: r
        }
    }
}