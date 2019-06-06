class MyCircularDeque(_k: Int) {

    /** Initialize your data structure here. Set the size of the deque to be k. */
    val k = _k + 1
    val q = new Array[Int](k)
    var head = 0
    var tail = 0

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    def insertFront(value: Int): Boolean = {
        if (isFull()) return false
        head = trim(head - 1)
        q(head) = value
        true
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    def insertLast(value: Int): Boolean = {
        if (isFull()) return false
        q(tail) = value
        tail = trim(tail + 1)
        true
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    def deleteFront(): Boolean = {
        if (isEmpty()) return false
        head = trim(head +1)
        true
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    def deleteLast(): Boolean = {
        if (isEmpty()) return false
        tail = trim(tail -1)
        true
    }

    /** Get the front item from the deque. */
    def getFront(): Int = {
        if (isEmpty()) return -1
        q(head)
    }

    /** Get the last item from the deque. */
    def getRear(): Int = {
        if (isEmpty()) return -1
        q(trim(tail -1))
    }

    /** Checks whether the circular deque is empty or not. */
    def isEmpty(): Boolean = {
        return head == tail
    }

    /** Checks whether the circular deque is full or not. */
    def isFull(): Boolean = {
        return trim(tail + 1) == head
    }
    
    def trim(n: Int) : Int = {
        if (n<0) n + k
        else if (n>=k) n - k
        else n
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */