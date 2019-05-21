class StreamChecker(_words: Array[String]) {

    var root = new Node
    
    for (w <- _words) {
        var n = root
        for (c<-w) {
            val index = c - 'a'
            if (n(index) == null) n(index) = new Node
            n = n(index)
        }
        n.isEnd = true
    }
    
    var list = List(root)
    
    def query(letter: Char): Boolean = {
        var nextList = List(root)
        var r = false
        for (n<-list) {
            val index = letter - 'a'
            val next = n(index)
            if (next != null) {
                nextList = next :: nextList
                if (next.isEnd) r = true
            }
        }
        list = nextList
        r
    }

}

class Node {
    val next = new Array[Node](26)
    var isEnd = false
    def apply(i : Int) : Node = next(i)
    def update(i : Int, v: Node) : Unit = {
        next(i) = v
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * var obj = new StreamChecker(words)
 * var param_1 = obj.query(letter)
 */