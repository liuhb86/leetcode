object Solution {
    def judgePoint24(nums: Array[Int]): Boolean = {
        for (p <- nums.map(_.toDouble).permutations) {
            val Array(n1,n2,n3,n4) = p
            for (o1 <- "+-*/") {
                for (o2 <- "+-*/") {
                    for (o3 <- "+-*/") {
                        // 123,132,213,312,321
                        if (eq(c(c(c(n1,n2,o1),n3,o2),n4,o3))) {
                            println(s"$n1$o1$n2$o2$n3$o3$n4,123")
                            return true
                        }
                        if (eq(c(c(n1,n2,o1),c(n3,n4,o3),o2))) {
                            println(s"$n1$o1$n2$o2$n3$o3$n4,132")
                            return true
                        }
                        if (eq(c(c(n1,c(n2,n3,o2),o1),n4,o3))) {
                            println(s"$n1$o1$n2$o2$n3$o3$n4,213")
                            return true
                        }
                        if (eq(c(n1,c(c(n2,n3,o2),n4,o3),o1))) {
                            println(s"$n1$o1$n2$o2$n3$o3$n4,312")
                            return true
                        }
                        if (eq(c(n1,c(n2,c(n3,n4,o3),o2),o1))) {
                            println(s"$n1$o1$n2$o2$n3$o3$n4,321")
                            return true
                        }
                    }
                }
            }
        }
        false
    }
                            
    
    def eq(n: Double) : Boolean = {
        scala.math.abs(n - 24) < 1e-5
    }
    
    def c(n1: Double, n2: Double, o: Char) : Double = o match {
        case '+' => n1 + n2
        case '-' => n1 - n2
        case '*' => n1 * n2
        case '/' => n1 / n2
    }
}