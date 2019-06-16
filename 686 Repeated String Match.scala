object Solution {
    def repeatedStringMatch(A: String, B: String): Int = {
        val r = if (B.length % A.length==0) B.length / A.length else B.length / A.length + 1
        val ra = A* r
        if (ra.contains(B)) return r
        if ((ra ++ A).contains(B)) return r +1
        -1
    }
}