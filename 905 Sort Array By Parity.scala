object Solution {
    def sortArrayByParity(A: Array[Int]): Array[Int] = {
        val (e,o) = A.partition(x=>(x & 1) == 0)
        e ++ o
    }
}