import scala.util.control.Breaks._
object Solution {
    def prevPermOpt1(A: Array[Int]): Array[Int] = {
        var a = -1 
        breakable{
            for (i <- A.length -2 to 0 by -1) {
                if (A(i) > A(i +1)) {
                    a = i
                    break
                }
            }
        }
        if (a == -1) return A
        var b = -1
        val v = A(a)
        breakable {
            for (i <- A.length -1  until a by -1) {
                if (A(i) < v && A(i) != A(i-1)) {
                    b = i
                    break
                }
            }
        }
        A(a) = A(b)
        A(b) = v
        A
    }
}