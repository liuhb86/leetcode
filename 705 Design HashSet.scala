class MyHashSet() {

    /** Initialize your data structure here. */
    val SIZE = 65536
    val MASK = SIZE - 1
    val bucket = new Array[Node](SIZE)

    def add(key: Int) {
        if (contains(key)) return
        val b = key & MASK
        val node = new Node(key)
        node.next = bucket(b)
        bucket(b) = node
    }

    def remove(key: Int) {
        var q : Node = null
        var p = bucket(key & MASK)
        while (p != null) {
            if (p.n == key) {
                if (q == null) {
                    bucket(key & MASK) = p.next
                } else {
                    q.next = p.next
                }
                p.next = null
                return
            }
            q = p
            p = p.next
        }
    }

    /** Returns true if this set contains the specified element */
    def contains(key: Int): Boolean = {
        var p = bucket(key & MASK)
        while (p != null) {
            if (p.n == key) return true
            p = p.next
        }
        false
    }

}

class Node(val n: Int) {
    var next: Node = null
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */