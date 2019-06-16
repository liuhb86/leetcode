object Solution {
    def largestValsFromLabels(values: Array[Int], labels: Array[Int], num_wanted: Int, use_limit: Int): Int = {
        val sorted = values.zip(labels).sortBy(-_._1)
        var sum = 0
        val used = new Array[Int](20010)
        var c = 0
        var i = 0
        while(i< sorted.length && c< num_wanted) {
            val (v,l) = sorted(i)
            if (v<=0) return sum
            if (used(l) < use_limit) {
                sum += v
                used(l) += 1
                c+=1
            }
            i+= 1
        }
        sum
    }
}