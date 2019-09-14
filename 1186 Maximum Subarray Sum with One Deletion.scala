object Solution {
    def maximumSum(arr: Array[Int]): Int = {
        var r = Int.MinValue
        var vmin = 0
        var vmind = 0
        var s = 0
        for (i<- arr.indices) {
            s = s + arr(i)
            r = r.max(s - vmin.min(vmind))
            if (vmin + arr(i) < vmind) vmind = vmin + arr(i)
            if (s<vmin) vmin = s
            //println(i, r, s, vmin, vmind)
        }
        r
    }
}