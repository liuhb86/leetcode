object Solution {
    def pathInZigZagTree(label: Int): List[Int] = {
        var n = label
        var p = Integer.highestOneBit(label)
        var r : List[Int] = Nil
        while (n>0) {
            r = n :: r
            n = n >> 1
            // p = p >> 1; n = p + p -1 - (n-p) 
            val p2 = p
            p = p >> 1
            n = p2 + p -n - 1
        }
        r
    }
}