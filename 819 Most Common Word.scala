object Solution {
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    val bannedSet = banned.toSet
    paragraph.replaceAll("[!?',;.]", " ")
      .toLowerCase.split(" +", 0)
      .groupBy(identity)
      .mapValues(_.length)
      .filter(x=> !bannedSet.contains(x._1))
      .maxBy(_._2)._1
  }
}