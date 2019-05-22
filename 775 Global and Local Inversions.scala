object Solution {
    def isIdealPermutation(A: Array[Int]): Boolean = {
        val t = A.zipWithIndex
        var f = t.indexWhere(p=> p._1 != p._2)
        while (f >= 0) {
            //println(f)
            if (!(A(f) == f + 1 && A(f+1)==f)) return false
            f = t.indexWhere(p => p._1 != p._2, f+2) 
        }
        true
    }
}