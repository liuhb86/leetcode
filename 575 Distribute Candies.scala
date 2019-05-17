object Solution {
    def distributeCandies(candies: Array[Int]): Int = {
        val group = candies.groupBy(identity)
        val totalKinds = group.size
        var onlyOnes = 0
        var commonOdds = 0
        for (g <- group.values) {
            if (g.length == 1) onlyOnes += 1
            else commonOdds += (g.length - 2)
        }
        val commonKinds = totalKinds - onlyOnes
        if (commonOdds >= onlyOnes) {
            commonKinds + onlyOnes
        } else {
            commonKinds + commonOdds + (onlyOnes - commonOdds) / 2
        }
    }
}