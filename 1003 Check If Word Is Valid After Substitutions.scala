object Solution {
    def isValid(S: String): Boolean = {
        val stack = scala.collection.mutable.ArrayBuffer[Char]()
        for (c<-S) {
            if (c=='a') {
                stack += 'b'
            } else {
                if (stack.isEmpty || stack.last != c) return false
                if (c=='b') {
                    stack(stack.length - 1) = 'c'
                } else {
                    stack.trimEnd(1)
                }
            }
        }
        stack.isEmpty
    }
}