class NumArray(_nums: Array[Int]) {
    
    val tree = if (_nums.isEmpty) null else build(_nums, 0)

    def update(i: Int, `val`: Int) : Unit = {
        update(tree, i, `val`)
    }
    
    def update(node: Node, i:Int, v: Int) : Unit = {
        if (node.i == node.j) {
            node.sum = v
            return
        }
        if (i >= node.right.i) update(node.right, i, v)
        else update(node.left, i, v)
        node.sum = node.left.sum + node.right.sum
    }

    def sumRange(i: Int, j: Int): Int = {
        //println(s"sum $i,$j")
        if (tree == null) return 0
        sumRange(tree, i, j)
    }
    
    def sumRange(node: Node, i: Int, j: Int) : Int = {
        //println(s"[${node.i},${node.j}] $i,$j")
        if (i == node.i && j == node.j) node.sum
        else if (j <= node.left.j) sumRange(node.left, i, j)
        else if (i >= node.right.i) sumRange(node.right, i, j)
        else sumRange(node.left, i, node.left.j) + sumRange(node.right, node.right.i, j) 
    }
    
    def build(nums: Array[Int], i: Int) : Node = {
        if (nums.length == 1) return new Node(i, i, null, null, nums(0))
        val half = (nums.length + 1) / 2
        val (left, right) = nums.splitAt(half)
        val node = new Node(i, i+nums.length -1, build(left, i), build(right, i + half), 0)
        node.sum = node.left.sum + node.right.sum
        node
    }

}

class Node(val i : Int, val j : Int, val left: Node, val right:Node, s: Int) {
    var sum = s
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = new NumArray(nums)
 * obj.update(i,`val`)
 * var param_2 = obj.sumRange(i,j)
 */