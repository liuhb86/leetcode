import scala.math.abs
object Solution {
    def equalSubstring(s: String, t: String, maxCost: Int): Int = {
        var cost = maxCost
        var ml = 0
        var j = 0
        for (i<-s.indices) {
            j = j.max(i)
            while (j < s.length && cost >= abs(s(j)-t(j)))  {
                cost -= abs(s(j)-t(j))
                j += 1
            }
            ml = ml.max(j-i)
            if (j>i) cost += abs(s(i)-t(i))
        }
        ml
    }
}