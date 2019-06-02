import scala.collection.mutable.{Map, ArrayBuffer, ListBuffer}
import scala.util.Random
class RandomizedCollection() {

  /** Initialize your data structure here. */
  class Node(val v : Int) {
    var arrayIndex: Int = 0
  }

  val map = Map[Int, ListBuffer[Node]]()
  val array = ArrayBuffer[Node]()


  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  def insert(`val`: Int): Boolean = {
    val node = new Node(`val`)
    val group = map.getOrElseUpdate(`val`, ListBuffer[Node]())
    node.arrayIndex = array.length
    group += node
    array += node
    group.length == 1
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  def remove(`val`: Int): Boolean = {
    if (!map.contains(`val`)) return false
    val group = map(`val`)
    val node = group.last
    group.trimEnd(1)
    if (group.isEmpty) map -= `val`
    if (node.arrayIndex != array.length -1) {
      val rnode = array.last
      array(node.arrayIndex) = rnode
      rnode.arrayIndex = node.arrayIndex
    }
    array.trimEnd(1)
    true
  }

  /** Get a random element from the collection. */
  def getRandom(): Int = {
    array(Random.nextInt(array.length)).v
  }

}

/**
  * Your RandomizedCollection object will be instantiated and called as such:
  * var obj = new RandomizedCollection()
  * var param_1 = obj.insert(`val`)
  * var param_2 = obj.remove(`val`)
  * var param_3 = obj.getRandom()
  */