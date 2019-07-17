object Solution {
    def validateStackSequences(pushed: Array[Int], popped: Array[Int]): Boolean = {
        var stack : List[Int] = Nil
        var i = 0
        for (p<-popped) {
            if (stack != Nil && stack.head == p) {
                stack = stack.tail
            } else {
                while(i<pushed.length && pushed(i) != p) {
                    stack = pushed(i) :: stack
                    i+=1
                }
                if (i==pushed.length) return false
                i+=1
            }
        }
        true
    }
}