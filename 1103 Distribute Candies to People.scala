import scala.math.sqrt
object Solution {
    def distributeCandies(candies: Int, num_people: Int): Array[Int] = {
        //k * (1+n)*n/2 + n*n * k * (k-1) * / 2
        // (nk+ nnk + nnkk -nnk)/2
        // nnkk + nk = 2c
        // k =  (-1 + sqrt(1+8c)) /2n
        val k = ((sqrt(8* candies.toDouble + 1) -1) / 2 / num_people).toInt
        val r = new Array[Int](num_people)
        var left = candies
        if (k>0) {
            // k+ (k-1)k/2*n
            var c = k + k * (k-1) / 2 * num_people
            for (i<-r.indices) {
                r(i) = c
                left -= c
                c += k
            }
        }
        var c = k * num_people + 1
        for (i<-r.indices) {
            c = c.min(left)
            if (c==0) return r
            r(i) += c
            left -= c
            c += 1
        }
        r
    }
}