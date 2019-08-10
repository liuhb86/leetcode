import java.util.TreeMap
object Solution {
    def oddEvenJumps(A: Array[Int]): Int = {
        val reachOdd = new Array[Boolean](A.length)
        val reachEven = new Array[Boolean](A.length)
        val map = new TreeMap[Int, Int]()
        reachOdd(A.length - 1) = true
        reachEven(A.length -1) = true
        map.put(A.last, A.length -1)
        for (i<- A.length -2 to 0 by -1) {
            val n = A(i)
            val ceiling = map.ceilingEntry(n)
            reachOdd(i) = (ceiling != null) && reachEven(ceiling.getValue)
            val floor = map.floorEntry(n)
            reachEven(i) = (floor != null) && reachOdd(floor.getValue)
            map.put(n, i)
        }
        reachOdd.count(identity)
    }
}