object Solution {
    def change(amount: Int, coins: Array[Int]): Int = {
        val dp = new Array[Int](amount+1)
        dp(0) = 1
        for (c <- coins) {
            for (j <- c to amount) {
                dp(j) += dp(j-c)
            }
        }
        dp(amount)
    }
}