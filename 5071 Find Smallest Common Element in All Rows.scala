
object Solution {
    def smallestCommonElement(mat: Array[Array[Int]]): Int = {
        var r = mat.head.head
        val p = new Array[Int](mat.length)
        var i = 0
        var j = (i + 1) % mat.length
        while(j != i) {
            while (p(j) < mat(j).length && mat(j)(p(j)) < r) p(j) +=1
            if (p(j) == mat(j).length) return -1
            if (mat(j)(p(j)) > r) {r = mat(j)(p(j)); i=j}
            j = (j + 1) % mat.length
        }
        r
    }
}