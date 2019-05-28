object Solution {
  def licenseKeyFormatting(S: String, K: Int): String = {
    val t = S.replaceAll("-", "").toUpperCase
    val ns = (K - t.length % K) % K
    val t2 = (" " * ns) ++ t
    (0 until t2.length / K).map(i => t2.substring(i * K, i*K+K)).mkString("-").trim
  }
}