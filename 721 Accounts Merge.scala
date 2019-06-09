import scala.collection.mutable.{Map,Set}
object Solution {
    def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
        val map = Map[String, Account]()
        var result : List[Account] = Nil
        for (name :: emails <- accounts) {
            val account = new Account(name)
            for (e<- emails) {
                if (map.contains(e)) {
                    val r = getRoot(map(e))
                    r.parent = account
                } else {
                    map(e) = account
                }
            }
        }
        map.groupBy(x => getRoot(x._2)).toList.map {
            case (acc, emails) => 
                acc.name :: emails.map(_._1).toList.sorted
        }
    }
    
    def getRoot(account: Account) : Account ={
        var p = account
        while(p.parent != p) {
            val t = p.parent
            p.parent = t.parent
            p = t
        }
        p
    }
}

class Account(val name: String) {
    var parent : Account = this
}