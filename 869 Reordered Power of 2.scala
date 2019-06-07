object Solution {
    val s = (0 to 30).map(x => (1 << x).toString.sorted).toSet
    def reorderedPowerOf2(N: Int): Boolean = {
        s.contains(N.toString.sorted)
    }
}