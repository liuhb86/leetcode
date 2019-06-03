object Solution {
    def addToArrayForm(A: Array[Int], K: Int): List[Int] = {
        var n = K
        var i = A.length - 1
        var r : List[Int] = Nil
        while (i>=0 || n != 0) {
            if (i>=0) n += A(i)
            r = (n % 10) :: r
            n = n / 10
            i -= 1
        }
        r
    }
}