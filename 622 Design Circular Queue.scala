class MyCircularQueue(_k: Int) {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    val L = _k +1
    val q = new Array[Int](L)
    var head = 0
    var tail = 0

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    def enQueue(value: Int): Boolean = {
        if (isFull()) return false
        q(tail) = value
        tail = trim(tail+1)
        true
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    def deQueue(): Boolean = {
        if (isEmpty()) return false
        head = trim(head+1)
        true
    }

    /** Get the front item from the queue. */
    def Front(): Int = {
        if (isEmpty()) return -1
        q(head)
    }

    /** Get the last item from the queue. */
    def Rear(): Int = {
        if (isEmpty()) return -1
        q(trim(tail -1))
    }

    /** Checks whether the circular queue is empty or not. */
    def isEmpty(): Boolean = {
        head == tail
    }

    /** Checks whether the circular queue is full or not. */
    def isFull(): Boolean = {
        trim(tail + 1) == head
    }
    
    private def trim(i: Int) : Int = {
        if (i<0) i + L
        else if (i>=L) i-L
        else i
    }

}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = new MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */