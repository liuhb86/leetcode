object Solution {
    def confusingNumber(N: Int): Boolean = {
        val map = Array((0,0),(1,1),(6,9), (8,8),(9,6))
            .map(x=> ((x._1 + '0').toChar, (x._2+'0').toChar))
            .toMap
        val ns = N.toString
        if (!ns.forall(x=> map.contains(x))) return false
        ns.map(x=> map(x)).reverse.toInt != N
    }
}