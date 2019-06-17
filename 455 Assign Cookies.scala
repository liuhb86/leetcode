object Solution {
    def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
        val gs = g.sorted
        val ss = s.sorted
        var i = 0
        var j = 0
        var r = 0
        while (i< gs.length && j < ss.length) {
            if (ss(j)>=gs(i)) {
                r += 1; i+=1
            }
            j+=1
        }
        r
    }
}