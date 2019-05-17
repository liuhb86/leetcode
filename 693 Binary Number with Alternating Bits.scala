object Solution {
    def hasAlternatingBits(n: Int): Boolean = {
        val t = if (n % 2 ==0) n.toLong * 3 /2  else n.toLong * 3 
        (t & (t+1)) == 0 
    }
}