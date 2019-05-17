import scala.collection.mutable
class RandomizedSet() {

    /** Initialize your data structure here. */
    val map = mutable.Map[Int, Int]()
    val arr = mutable.ArrayBuffer[Int]()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    def insert(`val`: Int): Boolean = {
        val v = `val`
        if (map.contains(v)) return false
        map(v) = arr.length
        arr += v
        true
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    def remove(`val`: Int): Boolean = {
        val v = `val`
        if (!map.contains(v)) return false
        val index = map(v)
        if (index != arr.length -1) {
            val t = arr.last
            arr(index) = t
            map(t) = index
        }
        map -= v
        arr.trimEnd(1)
        true
    }

    /** Get a random element from the set. */
    def getRandom(): Int = {
        arr(scala.util.Random.nextInt(arr.length))
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */