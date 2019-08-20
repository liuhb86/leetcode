import scala.collection.mutable.Set
class PhoneDirectory(_maxNumbers: Int) {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    val assigned = Set[Int]()
    val released = Set[Int]()
    var next: Int = 0
    

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    def get(): Int = {
        if (released.nonEmpty) {
            val n = released.head
            released -= n
            assigned += n
            n
        } else if (next < _maxNumbers) {
            val n = next
            next += 1
            assigned += n
            n
        } else {
            -1
        }
    }

    /** Check if a number is available or not. */
    def check(number: Int): Boolean = {
        if (number >= _maxNumbers) return false
        if (number >= next) return true
        !assigned(number)
    }

    /** Recycle or release a number. */
    def release(number: Int) {
        if (!assigned(number)) return
        assigned -= number
        released += number
    }

}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * var obj = new PhoneDirectory(maxNumbers)
 * var param_1 = obj.get()
 * var param_2 = obj.check(number)
 * obj.release(number)
 */