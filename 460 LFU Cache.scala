import scala.collection.mutable.Map
class LFUCache(_capacity: Int) {

  val map = Map[Int, DoubleLinkedNode[ItemNode]]()
  val freqList = new DoubleLinkedNode(new FreqNode(0))
  freqList.value.items.append(new ItemNode(0))

  def get(key: Int): Int = {
    //println(s"get $key")
    val r = map.get(key)
    if (r.isEmpty) return -1
    val node = r.get
    updateNode(node)
    node.value.value
  }

  def put(key: Int, value: Int) {
    //println(s"put $key $value")
    if (_capacity <=0) return
    val node = map.getOrElseUpdate(key, newNode(key))
    node.value.value = value
    updateNode(node)
  }

  def newNode(key: Int) : DoubleLinkedNode[ItemNode] = {
    if (_capacity >0 && map.size == _capacity) {
      removeLastItem()
    }
    val node = freqList.value.items.append(new ItemNode(key))
    node.value.parent = freqList
    node
  }

  def removeLastItem() {
    val freqNode = freqList.next
    val node = freqNode.value.items.prev
    map -= node.value.key
    removeNode(node)
  }

  def removeNode(node: DoubleLinkedNode[ItemNode]) {
    val freqNode = node.value.parent
    node.remove()
    if (freqNode.value.items.isEmpty()) {
      freqNode.remove()
    }
  }

  def updateNode(node : DoubleLinkedNode[ItemNode]) {
    val freqNode = node.value.parent
    val freq = freqNode.value.freq + 1
    val newFreqNode =
      if (freqNode.next.value.freq == freq) {
        freqNode.next
      } else {
        freqNode.append(new FreqNode(freq))
      }
    removeNode(node)
    node.value.parent = newFreqNode
    newFreqNode.value.items.append(node)
  }
}

class DoubleLinkedNode[T](val value: T) {
  var prev : DoubleLinkedNode[T] = this
  var next : DoubleLinkedNode[T] = this

  def append(node: DoubleLinkedNode[T]): Unit = {
    val next = this.next
    node.prev = this
    node.next = next
    this.next = node
    next.prev = node
  }

  def append(value : T): DoubleLinkedNode[T] = {
    val node = new DoubleLinkedNode(value)
    append(node)
    node
  }

  def remove(): Unit = {
    prev.next = next
    next.prev = prev
  }

  def isEmpty() = next == this
}

class FreqNode(val freq: Int) {
  val items = new DoubleLinkedNode(new ItemNode(0))
}

class ItemNode(val key: Int) {
  var value = 0
  var parent: DoubleLinkedNode[FreqNode] = _
}

/**
  * Your LFUCache object will be instantiated and called as such:
  * var obj = new LFUCache(capacity)
  * var param_1 = obj.get(key)
  * obj.put(key,value)
  */