object Solution {
    def numRescueBoats(people: Array[Int], limit: Int): Int = {
        val s = people.sorted
        var r = 0
        var i = 0
        var j = s.length - 1
        while (i<=j) {
            r += 1
            if (s(j) + s(i)<=limit) i+=1
            j-=1
        }
        r
    }
}