object Solution {
    def isMonotonic(A: Array[Int]): Boolean = {
        var inc : Option[Boolean] = None
        var p = A(0)
        for (n <- A.tail) {
            if (n != p) {
                if (inc.isEmpty) inc = Some(p < n)
                else if ((p<n) != inc.get) return false
            }
            p = n
        }
        true
    }
}