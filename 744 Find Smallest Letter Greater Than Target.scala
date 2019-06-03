object Solution {
    def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
        val d = letters.distinct
        var begin = 0
        var end = d.length
        while(end-begin > 1) {
            val mid = (begin + end -1)/2
            if (d(mid) <= target) {
                begin = mid + 1
            } else {
                end = mid + 1
            }
        }
        if (begin == end || d(begin) <=target) return d.head else d(begin)
    }
}