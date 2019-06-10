object Solution {
    def pancakeSort(A: Array[Int]): List[Int] = {
        var r : List[Int] = Nil
        for (i<-A.length to 2 by -1) {
            var mi = 0
            var mv = A(0)
            for (j<-1 until i) {
                val v = A(j)
                if (v>mv) {mv = v;mi=j}
            }
            //println(s"$i,$mi,$mv")
            if (A(i-1) != mv) {
                if (A(0) != mv) {
                    flip(A, mi+1)
                    r = (mi+1) :: r
                }
                flip(A, i)
                r = i :: r
            }
        }
        r.reverse
    }
    def flip(A: Array[Int], _j: Int) = {
        var i = 0
        var j= _j - 1
        while (i < j) {
            val t= A(i)
            A(i) = A(j); A(j) = t
            i+=1; j -=1;
        }
        //println("F: " + A.mkString(","))
    }
}
