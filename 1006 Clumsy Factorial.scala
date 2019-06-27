object Solution {
    def clumsy(N: Int): Int = {
        var r = 0
        var x = N
        var s = 1 
        while (x > 0) {
             x match {
                 case 1 => return r +  s * 1
                 case 2 => return r +  s* 2 * 1
                 case _ => 
                    r += s * x * (x-1) / (x-2) + (x-3)
                    s = -1
                    x-= 4
             }  
        }
        r
    }
}