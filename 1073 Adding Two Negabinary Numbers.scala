import scala.math.max
object Solution {
    def addNegabinary(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
        val a1 = arr1.reverse
        var a2 = arr2.reverse
        var r = new Array[Int](max(a1.length, a2.length) + 2)
        var c = 0
        for (i<-0 until r.length) {
            val d1 = if (i<a1.length) a1(i) else 0
            val d2 = if (i<a2.length) a2(i) else 0
            val s = d1 + d2 + c
            val (d3, c3) = s match {
                case 0=>(0,0)
                case 1 => (1,0)
                case 2 => (0, -1)
                case 3 => (1, -1)
                case -1 => (1, 1)
            }
            r(i) = d3
            c = c3
        }
        var j = r.length -1
        while (j > 0 && r(j) == 0) j -= 1
        r.take(j + 1).reverse
    }
}