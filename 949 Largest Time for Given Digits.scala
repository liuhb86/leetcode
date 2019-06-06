object Solution {
    def largestTimeFromDigits(A: Array[Int]): String = {
        try {
           solve(A, 2)
        } catch {
            case e: Exception => try {
                solve(A, 1)
            } catch {
                case e : Exception => return ""
            }
        }
    }
    
    def solve (A: Array[Int], u: Int) : String = {
        val r = new scala.collection.mutable.StringBuilder
        val (d1, a1) = takeMax(A, u)
        r += d1
        val (d2, a2) = takeMax(a1, if (d1=='2') 3 else 9)
        r += d2
        r += ':'
        val (d3, a3) = takeMax(a2, 5)
        r += d3
        val (d4, a4) = takeMax(a3, 9)
        r += d4
        r.toString
    }
    
    def takeMax(A: Array[Int], u: Int) :(Char, Array[Int]) ={
        var mi = -1
        var m = -1
        for (i<- A.indices) {
            if (A(i) <=u && A(i) > m) {
                m = A(i)
                mi = i
            }
        }
        if (mi < 0) throw new Exception()
        val b = A.take(mi) ++ A.drop(mi + 1)
        (('0' + m).toChar, b)
    }
}