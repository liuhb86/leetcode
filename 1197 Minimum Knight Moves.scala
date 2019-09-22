object Solution {
    def minKnightMoves(_x: Int, _y: Int): Int = {
        var x = _x; var y = _y
        if (x<0) x = -x;
        if (y<0) y = -y
        if (y>x) {val t=x;x=y;y=t;}
        //val b = x/8 * 4
        //x = x%8; y=y% 8
        //move(x,y) + b
        move(x,y)
    }
    
    val dir = Array((1,2), (2,1), (2,-1), (1,-2),(-1,-2),(-2,-1), (-2,1), (-1,2))
    def move(x: Int, y: Int) : Int = {
        if (x==0 && y==0) return 0
        val visited = scala.collection.mutable.Set[(Int, Int)]()
        var list = List((0,0))
        visited += ((0,0))
        var r = 0
        while (list.nonEmpty) {
            r+=1
            var next: List[(Int, Int)] = Nil
            for ((i0,j0)<-list) {
                for ((di,dj)<-dir) {
                    val p = (i0+di, j0+dj)
                    if (p._1==x && p._2==y) return r
                    if (r>5 && (p._1<0 || p._2 <0)) {
                        
                    } else if (!visited(p)) {
                        visited += p
                        next = p :: next
                    }
                }
            }
            list = next
        }
        0
    }
}