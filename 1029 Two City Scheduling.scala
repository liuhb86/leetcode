object Solution {
    def twoCitySchedCost(costs: Array[Array[Int]]): Int = {
        val n = costs.length / 2
        val sorted = costs.sortBy(p => p(0) - p(1))
        sorted.take(n).map(_(0)).sum + sorted.drop(n).map(_(1)).sum
    }
}