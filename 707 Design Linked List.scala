class MyLinkedList() {

    /** Initialize your data structure here. */
    val root = new Item(0)
    var length = 0
    var tail : Item = root

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    def get(index: Int): Int = {
        if (index < 0 || index >= length) return -1
        var n = root
        for (i<-0 to index) n = n.next
        n.v
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    def addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    /** Append a node of value val to the last element of the linked list. */
    def addAtTail(`val`: Int) {
        val n = new Item(`val`)
        length += 1
        tail.next = n
        tail = n
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    def addAtIndex(index: Int, `val`: Int) {
        if (index > length) return
        val n = new Item(`val`)
        var p = root
        // spec issue: negative index
        for (i<-0 until scala.math.max(0,index)) p = p.next
        n.next = p.next
        p.next = n
        length += 1
        if (n.next == null) tail = n
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    def deleteAtIndex(index: Int) {
        if (index <0 || index >= length) return
        var p = root
        for (i<-0 until index) p = p.next
        p.next = p.next.next
        length -= 1
        if (p.next == null) tail = p
    }

}

class Item(val v: Int) {
    var next : Item = null
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */