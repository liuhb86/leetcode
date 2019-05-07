object Solution {
    def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
        A.map(row => row.reverse.map( 1 - _))
    }
}