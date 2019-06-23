object Solution {
    def carPooling(trips: Array[Array[Int]], capacity: Int): Boolean = {
        val a1 = trips.map(x => (x(1), x(0)))
        val a2 = trips.map(x => (x(2), -x(0)))
        val sorted = (a1 ++ a2).sorted
        var c = 0
        for ((_, p) <- sorted) {
            c += p
            if (c > capacity) return false
        }
        true
    }
}