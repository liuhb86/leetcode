class ExamRoom(N: Int) {

  val fromMap = scala.collection.mutable.Map[Int,Seat]()
  val toMap = scala.collection.mutable.Map[Int,Seat]()
  val seats = new scala.collection.mutable.TreeSet[Seat]()(Ordering.by(x=> (-x.dis,x.sit)))
  seats += new Seat(0, N-1, N)

  def seat(): Int = {
    if (seats.isEmpty) return -1
    val s = seats.head
    seats -= s
    val sit = s.sit
    val s1 = new Seat(s.from, sit-1, N)
    val s2 = new Seat(sit+1, s.to, N)
    if (s1.isValid) seats += s1
    if (s2.isValid) seats += s2
    fromMap(s.from) = s1
    if (s1.isValid) toMap(sit-1) = s1
    if (s2.isValid) fromMap(sit+1) = s2
    toMap(s.to) = s2
    sit
  }

  def leave(p: Int) {
    val s1 = toMap.getOrElse(p-1, null)
    val s2 = fromMap.getOrElse(p+1, null)
    if (s1!= null && s1.isValid) seats -= s1
    if (s2 != null && s2.isValid) seats -= s2
    val from = if (s1!= null && s1.isValid) s1.from else p
    val to = if (s2!=null && s2.isValid) s2.to else p
    val s = new Seat(from, to, N)
    seats += s
    fromMap(from) = s
    toMap(to) = s
  }

}

/**
  * Your ExamRoom object will be instantiated and called as such:
  * var obj = new ExamRoom(N)
  * var param_1 = obj.seat()
  * obj.leave(p)
  */

class Seat(val from: Int, val to: Int, N: Int) {
  val isValid = (from <= to)
  val sit =
    if (from == 0) 0
    else if (to == N-1) N - 1
    // 0..0->0, 0..1->0,0..2->1
    else (from + to) / 2
  val dis =
    if (from == 0) to - sit + 1
    else if (to == N-1) sit - from + 1
    else (to-sit).min(sit-from)+1
}