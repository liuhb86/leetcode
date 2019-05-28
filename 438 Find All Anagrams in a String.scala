object Solution {
  def findAnagrams(s: String, p: String): List[Int] = {
    if (s.length < p.length) return Nil
    val c = new Array[Int](26)
    for (x <- p) {
      c(x-'a') -=1
    }
    for (i<- 0 until p.length -1) {
      c(s(i) - 'a') +=1
    }
    var d = c.count(_!=0)
    val r = new scala.collection.mutable.ListBuffer[Int]()
    for (i<-0 to s.length - p.length) {
      val ia = s(i + p.length -1) - 'a'
      if (c(ia) == 0) d += 1
      c(ia) += 1
      if (c(ia) == 0) d-=1
      if (d == 0) r += i
      val ib = s(i) - 'a'
      if (c(ib) ==0) d+=1
      c(ib) -=1
      if (c(ib) == 0) d-=1
    }
    r.toList
  }
}