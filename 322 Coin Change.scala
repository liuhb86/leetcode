object Solution {
    def coinChange(coins: Array[Int], amount: Int): Int = {
        val dp = Array.fill(amount+1)(-1)
        dp(0) = 0
        for (c<-coins) {
            for (i<-c to amount){
                val x = dp(i-c)
                if (x >= 0 && (dp(i)< 0 || x + 1 < dp(i))) dp(i) = x + 1
            }
        }
        dp(amount)
    }
}