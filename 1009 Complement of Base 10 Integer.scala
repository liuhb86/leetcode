object Solution {
    def bitwiseComplement(N: Int): Int = {
        if (N==0) return 1
        var m = 1
        while (m < N) m <<= 1
        (~N) & (m -1)
    }
}