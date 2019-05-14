object Solution {
    def findComplement(num: Int): Int = {
        var t : Long = 1L
        while (t <= num) t<<=1
        (t - 1 - num).toInt
    }
}