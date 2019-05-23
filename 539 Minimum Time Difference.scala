object Solution {
    val p = "(.*):(.*)".r
    def findMinDifference(timePoints: List[String]): Int = {
        if (timePoints.length > 60 * 24) return 0
        val sorted = (timePoints.map{
            case p(h,m) => h.toInt*60+m.toInt
        }).sortBy(identity)
        ((1 until sorted.length).map(i => sorted(i) -sorted(i-1)) :+ (sorted.head + 60*24 - sorted.last)).min
    }
}