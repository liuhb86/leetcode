import scala.collection.mutable.{ArrayBuffer, PriorityQueue, Set}
class MaxStack() {

    /** initialize your data structure here. */
    val stack = ArrayBuffer[Num]()
    val pq = PriorityQueue[Num]()(Ordering.by(x=> (x.n, x.pos)))
    val rmStack = Set[Num]()
    val rmPq = Set[Num]()

    def push(x: Int) {
        val n = new Num(x, stack.length)
        stack += n
        pq += n
        //dbprint()
    }

    def pop(): Int = {
        trimStack()
        val v = stack.last
        stack.trimEnd(1)
        rmPq += v
        //dbprint()
        v.n
    }

    def top(): Int = {
        trimStack()
        //dbprint()
        stack.last.n
    }

    def peekMax(): Int = {
        trimPq()
        //dbprint()
        pq.head.n
    }

    def popMax(): Int = {
        trimPq()
        val v = pq.dequeue
        rmStack += v
        //dbprint()
        v.n
    }
    
    def trimStack() {
        while (stack.nonEmpty && rmStack(stack.last)) {
            rmStack -= stack.last
            stack.trimEnd(1)
        }
    }
    
    def trimPq() {
        while (pq.nonEmpty && rmPq(pq.head)) {
            rmPq -= pq.dequeue 
        }
    }
    
    def dbprint() {
        println(stack.mkString(" "))
        println(rmStack.mkString(" "))
        println(pq.toArray.mkString(" "))
        println(rmPq.mkString(" "))
        println()
    }

}

class Num(val n: Int, val pos: Int) {
    
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * var obj = new MaxStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.peekMax()
 * var param_5 = obj.popMax()
 */