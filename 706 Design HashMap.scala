class MyHashMap() {

    /** Initialize your data structure here. */
    val SIZE = 65536
    val MASK = SIZE - 1
    val buckets = new Array[Node](SIZE)
    
    /** value will always be non-negative. */
    def put(key: Int, value: Int) {
        var p = buckets(key & MASK)
        var kp : Node = null
        while (kp == null && p != null) {
            if (p.key == key) {
                kp = p
            } else {
                p = p.next
            }
        }
        if (kp == null) {
            kp = new Node(key)
            kp.next = buckets(key & MASK)
            buckets(key & MASK) = kp
        }
        kp.value = value
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    def get(key: Int): Int = {
        var p = buckets(key & MASK)
        while (p != null) {
            if (p.key == key) return p.value
            p = p.next
        }
        -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    def remove(key: Int) {
        var q : Node = null
        var p = buckets(key & MASK)
        while (p!=null) {
            if (p.key == key) {
                if (q== null) {
                    buckets(key&MASK) = p.next
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

}

class Node(val key: Int) {
    var value : Int = 0
    var next: Node = null
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */