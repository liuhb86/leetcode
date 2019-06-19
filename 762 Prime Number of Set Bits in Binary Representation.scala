object Solution {
    val p = Set(2,3,5,7,11,13,17,19)
    def countPrimeSetBits(L: Int, R: Int): Int = {
        (L to R).count(x=> p.contains(Integer.bitCount(x)))
    }
}