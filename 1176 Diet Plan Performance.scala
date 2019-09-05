object Solution {
    def dietPlanPerformance(calories: Array[Int], k: Int, lower: Int, upper: Int): Int = {
        var r = 0
        var s = 0
        for (i<-0 until k-1) s += calories(i)
        for (i<-k-1 until calories.length) {
            s += calories(i)
            if (s<lower) r -= 1
            else if (s > upper) r+=1
            s -= calories(i-k+1)
        }
        r
    }
}