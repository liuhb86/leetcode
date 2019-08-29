object Solution {
    val a = Array(0,9,65,385,2009,9161,35177,108089,248793,389497)
    def numberOfPatterns(m: Int, n: Int): Int = {
        a(n) - a(m-1)
    }
}