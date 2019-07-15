object Solution {
    def maxDepthAfterSplit(seq: String): Array[Int] = {
        val root = new Node(-1)
        parse(root, seq, 0)
        val d = (root.depth - 1) / 2
        val r = new Array[Int](seq.length)
        for (c<-root.children) {
            choose(c, d, r);
        }
        r
    }
    
    def choose(node: Node, d: Int, r: Array[Int]) {
        if (node.depth <= d) return
        r(node.start) = 1
        r(node.end) = 1
        for (c<- node.children) {
            choose(c, d, r)
        }
    }
    
    def parse(node: Node, seq: String, _i: Int) : Int = {
        var i = _i
        var depth = 0
        while(i< seq.length && seq(i) =='(' ) {
            val c = new Node(i)
            node.children += c
            i = parse(c, seq, i + 1)
            depth = depth.max(c.depth)
        }
        node.end = i
        node.depth = depth + 1
        i + 1
    }
}

class Node(val start: Int) {
    var end: Int = 0
    var depth = 0
    val children = new scala.collection.mutable.ArrayBuffer[Node]()
}