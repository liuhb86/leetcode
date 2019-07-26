object Solution {
    def transpose(A: Array[Array[Int]]): Array[Array[Int]] = {
        A.head.indices.toArray.map(i=> A.map(_(i)))
    }
}