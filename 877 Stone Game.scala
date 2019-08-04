// c(L,i) = c(L-1,i) + p(i+L-1)
// dp(L, i) = max( p(i) + c(L-1, i+1) - dp(L-1, i+1),
//                   p(i+L-1) + c(L-1, i) - dp(L-1, i) ) 
object Solution {
    def stoneGame(piles: Array[Int]): Boolean = {
        val dp = piles.map(identity)
        val sum = piles.map(identity)
        for (L<-2 to piles.length) {
            for (i<- piles.length - L to 0 by -1) {
                val s = sum(i) + piles(i+L-1)
                val d = (piles(i) + sum(i+1) - dp(i+1)).max(
                    piles(i+L-1) + sum(i) - dp(i)
                )
                sum(i) = s
                dp(i) = d
            }
        }
        dp(0) > sum(0) - dp(0)
    }
}