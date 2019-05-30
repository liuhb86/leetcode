import scala.util.Try
object Solution {
  val neither = "Neither"
  def validIPAddress(IP: String): String = {
    if (IP.contains(":")) {
      val s = IP.split(":", -1)
      if (s.length != 8) return neither
      if (s.forall(_.matches("[0-9a-fA-F]{1,4}"))) "IPv6"
      else neither
    } else {
      val s = IP.split("\\.", -1)
      if (s.length != 4) return neither
      if (s.forall(x=> {
        val n = Try{x.toInt}.getOrElse(-1)
        n >=0 && n < 256 && n.toString == x
      })) "IPv4"
      else neither
    }
  }
}