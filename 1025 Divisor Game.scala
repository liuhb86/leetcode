object Solution {
    def divisorGame(N: Int): Boolean = {
        N % 2 == 0
    }
    
    def build() {    
        val a = new Array[Boolean](1001)
        
        def win(i: Int) : Boolean = {
            for (j<- 1 to i-1) {
                if (i % j == 0 && !a(i-j)) return true
            }
            false
        }
        
        for (i<-1 to 1000) {
            a(i) = win(i)
        }
        
        println(a.zipWithIndex.filter(_._1).map(_._2).mkString(" "))
    }
}