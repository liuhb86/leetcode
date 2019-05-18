object Solution {
    def canThreePartsEqualSum(A: Array[Int]): Boolean = {
        if (A.length < 3) return false
        val t = new Array[Int](A.length)
        t(0) = A(0)
        for (i<- 1 until A.length) t(i) = t(i-1) + A(i)
        val sum = t(A.length -1)
        if (sum % 3 != 0) return false
        val p = sum / 3
        val i = t.indexOf(p)
        if (i < 0) return false
        val j = t.lastIndexOf(p*2)
        if (j < 0) return false
        i < j
    }
}