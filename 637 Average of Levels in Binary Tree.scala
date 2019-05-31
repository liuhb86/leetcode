/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
    def averageOfLevels(root: TreeNode): Array[Double] = {
        if (root == null) return Array[Double]()
        val r = scala.collection.mutable.ListBuffer[Double]()
        var n = List(root)
        while (n.nonEmpty) {
            val v = n.toArray.map(_.value.toDouble)
            r += v.sum / v.length
            n = n.flatMap(x => List(x.left, x.right).filter(_!= null))
        }
        r.toArray
    }
}