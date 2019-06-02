object Solution {
  def numComponents(head: ListNode, G: Array[Int]): Int = {
    val s = G.toSet
    var n = false
    var c = 0
    var node = head
    while(node != null) {
      val nn = s.contains(node.x)
      if (nn) {
        if (!n) {
          c += 1
        }
      }
      n = nn
      node = node.next
    }
    c
  }
}