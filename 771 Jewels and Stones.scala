object Solution {
    def numJewelsInStones(J: String, S: String): Int = {
        val jewelSet = J.toSet
        S.count(jewelSet.contains(_))
    }
}