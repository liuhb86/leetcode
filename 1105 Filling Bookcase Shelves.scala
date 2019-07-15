object Solution {
    def minHeightShelves(books: Array[Array[Int]], shelf_width: Int): Int = {
        val dp = new Array[Int](books.length+1)
        dp(0) = 0
        for(k <- 1 to books.length) {
            var h = books(k-1)(1)
            var m = h + dp(k-1)
            var w = books(k-1)(0)
            var i = k-2
            while (i>=0 && w + books(i)(0) <=shelf_width) {
                w += books(i)(0)
                h = h.max(books(i)(1))
                m = m.min(h + dp(i))
                i-=1
            }
            dp(k) = m
        }
        //println(dp.mkString(" "))
        dp(books.length)
    }
}