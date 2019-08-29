object Solution {
    def shortestWay(source: String, target: String): Int = {
        var r = 0
        var j = 0
        while (j < target.length) {
            r += 1
            val _j = j
            var i = 0
            while (i< source.length && j < target.length) {
                if (source(i) == target(j)) j+=1
                i+=1
            }
            if (j==_j) return -1
        }
        r
    }
}