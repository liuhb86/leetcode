class AllOne() {

    /** Initialize your data structure here. */
    val list = new Node[F](new F(0))
    val map = scala.collection.mutable.Map[String, Node[V]]()

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    def inc(key: String) {
        if (map.contains(key)) {
            val n = map(key)
            val p = n.v.parent
            val v = p.v.v
            val np = if (p.next.v.v != v+1) p.append(new F(v+1)) else p.next
            map(key) = np.v.head.append(n.v); n.v.parent = np
            n.remove()
            if (p.v.head.isEmpty) p.remove()
        } else {
            val np = if (list.next.v.v != 1) list.append(new F(1)) else list.next
            val v = new V(key)
            map(key) = np.v.head.append(v); v.parent = np 
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    def dec(key: String) {
        if (!map.contains(key)) return
        val n = map(key)
        val p = n.v.parent
        val v = p.v.v
        if (v==1) {
            map -= key
        } else {
            val np = if (p.prev.v.v == v-1) p.prev else p.prev.append(new F(v-1))
            map(key) = np.v.head.append(n.v); n.v.parent = np
        }
        n.remove()
        if (p.v.head.isEmpty) p.remove()        
    }

    /** Returns one of the keys with maximal value. */
    def getMaxKey(): String = {
        if (list.isEmpty) return ""
        list.prev.v.head.next.v.k
    }

    /** Returns one of the keys with Minimal value. */
    def getMinKey(): String = {
        if (list.isEmpty) return ""
        list.next.v.head.next.v.k
    }

}

class Node[T](val v: T) {
    var prev = this
    var next = this
    def isEmpty = this.next == this
    def append(v: T) : Node[T] = {
        val n = new Node[T](v)
        n.next = next; n.prev = this
        this.next.prev = n
        this.next = n
        n
    }
    def remove() {
        this.prev.next = next
        this.next.prev = prev
        this.prev = null
        this.next = null
    }
}

class F(val v: Int) {
    val head = new Node[V](null)
}

class V(val k: String) {
    var parent : Node[F] = _
}

/**
 * Your AllOne object will be instantiated and called as such:
 * var obj = new AllOne()
 * obj.inc(key)
 * obj.dec(key)
 * var param_3 = obj.getMaxKey()
 * var param_4 = obj.getMinKey()
 */