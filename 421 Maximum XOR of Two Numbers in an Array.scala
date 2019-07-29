object Solution {
    def findMaximumXOR(nums: Array[Int]): Int = {
        val root = new Node()
        for (n<-nums) {
            var p = root
            for (i<-30 to 0 by -1) {
                val b = (n & (1<<i)) >> i
                p = p.getOrCreate(b)
            }
        }
        find(root, root, 30)
    }
    
    def find(n1: Node, n2: Node, i: Int) : Int = {
        if (i== -1) return 0
        if (n1==null || n2 == null) return 0
        if (n1(0)!= null && n2(1) != null ||
            n1(1) != null && n2(0)!= null) {
            find(n1(0), n2(1), i -1).max(find(n1(1), n2(0), i-1)) | (1<<i) 
        } else {
            find(n1(0), n2(0), i-1).max(find(n1(1), n2(1), i-1))
        }
    }
}

class Node {
    val children = new Array[Node](2)
    def getOrCreate(i: Int) : Node = {
        if (children(i) == null) children(i) = new Node()
        children(i)
    }
    def apply(i: Int) = children(i)
}