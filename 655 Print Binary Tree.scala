/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
import scala.math.max
object Solution {
    def printTree(root: TreeNode): List[List[String]] = {
        val pn = construct(root)
        val (height, width) = calcDim(pn)
        calcPos(pn,0, width - 1, 0)
        val result = Array.fill(height)(Array.fill(width)(""))
        fill(pn, result)
        result.map(_.toList).toList
    }
    
    def construct(n: TreeNode) : PrintNode = {
        if (n == null) return null
        new PrintNode(n, construct(n.left), construct(n.right))
    }
    
    def calcDim(n: PrintNode) : (Int, Int) = {
        if (n == null) return(0,0)
        val dl = calcDim(n.left)
        val dr = calcDim(n.right)
        val height = max(dl._1, dr._1) + 1
        val width = max(dl._2, dr._2) * 2 + 1
        (height, width)
    }
    
    def calcPos(n: PrintNode, x1: Int, x2: Int, y: Int) : Unit = {
        if (n == null) return
        n.y = y
        n.x =  (x1 + x2) / 2
        calcPos(n.left, x1, n.x - 1, y + 1)
        calcPos(n.right, n.x + 1, x2, y + 1)
    }
    
    def fill(n: PrintNode, result: Array[Array[String]]) : Unit = {
        if (n == null) return
        result(n.y)(n.x) = n.value
        fill(n.left, result)
        fill(n.right, result)
    }
}

class PrintNode(n: TreeNode, val left: PrintNode, val right: PrintNode) {
    val value = n.value.toString
    var y: Int = 0
    var x: Int = 0
}