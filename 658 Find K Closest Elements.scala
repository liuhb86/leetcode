import scala.collection.Searching._
object Solution {
    def findClosestElements(arr: Array[Int], k: Int, x: Int): List[Int] = {
        var r = k
        var a = 0
        var b = 0
        arr.search(x) match {
            case Found(i) =>
                a = i - 1
                b = i + 1
                r -= 1
                while (r > 0 && b<arr.length && arr(b) == x) {
                    b += 1
                    r -= 1
                }
                if (r == 0) return List.fill(k)(x)
            case InsertionPoint(i) =>
                a = i -1
                b = i
        }
        for (i <- 1 to r) {
            if (a < 0) b += 1
            else if (b >= arr.length) a -= 1
            else if (x - arr(a) <= arr(b) - x) a -= 1
            else b+=1
        }
        arr.slice(a+1, b).toList
    }
}