object Solution {
    def lastRemaining(n: Int): Int = {
        // length of n
        val t = n / 2
        var p = 1
        while (p <= t) p <<= 1
        
        p - ( (~n) & 0x2aaaaaaa & (p-1))
    /*
        1 2 3 4   *2
        
        1 3         
        1 2     *2 - 1  
        
        2                
        1        *2
        
        1 2 3 4 5 
         2 4    *2 
        1 2
        
        
        1001  
        1000 - 10
      */
    }
}