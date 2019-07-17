import scala.collection.mutable.{Map, Set}
import scala.math.sqrt
object Solution {
  def minAreaFreeRect(_points: Array[Array[Int]]): Double = {
    val points = _points.map(x=> (x(0), x(1)))
    val pointSet = points.toSet
    var r : Double = 0.0
    for (p <- points) {
      val hash = scala.collection.mutable.Map[(Int, Int), Set[(Int,Int)]]()
      for (q<- points) {
        val dx = q._1 - p._1
        val dy = q._2 - p._2
        val k = slope(dx,dy)
        if (dx != 0 || dy != 0) {
          val s = hash.getOrElseUpdate(k, Set())
          s += ((dx,dy))
        }
        val s = hash.getOrElse(reverse(k), Set())
        for (t<- s) {
          val x = t._1 + dx + p._1
          val y = t._2 + dy + p._2
          if (pointSet.contains((x,y))) {
            val area = sqrt(dx*dx+dy*dy) * sqrt(t._1*t._1 + t._2*t._2)
            r = if (r == 0.0) area else r.min(area)
          }
        }
      }
    }
    r
  }

  def slope(x: Int, y: Int) : (Int, Int) = {
    if (y<0) return slope(-x, -y)
    if (x==0 && y==0) return (0,0)
    if (x==0) return (0,1)
    if (y==0) return (1,0)
    val g = gcd(x,y)
    (x/g, y/g)
  }

  def reverse(k:(Int, Int)) : (Int, Int) = {
    if (k._1 > 0) (-k._2, k._1)
    else (k._2, -k._1)
  }

  def gcd(_x: Int, _y: Int) : Int =  {
    if (_x < 0) return gcd(-_x, _y)
    var x = _x
    var y = _y
    while(y > 0) {
      val r = x % y
      x = y
      y = r
    }
    x
  }
}