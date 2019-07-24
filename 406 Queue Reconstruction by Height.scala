object Solution {
    def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
        val sorted = people.sortBy(x => (-x(0), x(1)))
        var  q = new Node(null)
        for (p<- sorted) {
            val k = p(1)
            val node = new Node(p)
            var x = q
            for (i<-1 to k) {
                x = x.next
            }
            node.next = x.next; x.next = node
        }
        val r = new scala.collection.mutable.ArrayBuffer[Array[Int]](people.length)
        var x = q.next
        while (x!= null) {
            r += x.p
            x = x.next
        }
        r.toArray
    }
}

class Node(val p: Array[Int]) {
    var next : Node = null
}