import scala.util.control.Breaks._
object Solution {

  var prime : Array[Int] = null
  val M = 100000
  val primeSet = new Array[Boolean](M+1)

  def genPrime() = {
    val p = scala.collection.mutable.ArrayBuffer[Int]()
    for (i<-2 to M) {
      if (primeSet(i) == false) {
        p+=i
        for (j<- i+i to M by i) primeSet(j) = true
      }
    }
    prime = p.toArray
  }

  def largestComponentSize(A: Array[Int]): Int = {
    if (prime == null) genPrime()
    val map = scala.collection.mutable.Map[Int, Node]()
    var r = 0
    for (n<- A) {
      val node = new Node()
      var x = n
      if (primeSet(x) == false) {
        map(x) = node.union(map.get(x))
        x = 1
      }
      breakable {for(p<-prime) {
        if (p > x) break
        if (x % p == 0) {
          while (x % p == 0) x/=p
          map(p) = node.union(map.get(p))
          if (x> 1 && primeSet(x) == false) {
            map(x) = node.union(map.get(x))
            x = 1
          }
        }
      }}
      r = r.max(node.getRoot().size)
    }
    r
  }
}

class Node {
  var parent : Node = this
  var size: Int = 1
  def getRoot() : Node = {
    if (parent== this) return this
    val r = parent.getRoot()
    parent = r
    r
  }

  def union(p : Option[Node]) : Node = {
    if (p.isEmpty) return this
    val r1 = getRoot()
    val r2 = p.get.getRoot()
    if (r1 != r2) {
      r2.parent = r1
      r1.size += r2.size
    }
    r1
  }
}