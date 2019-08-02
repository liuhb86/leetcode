object Solution {
    def predictPartyVictory(senate: String): String = {
        val root = new Node(' ')
        var p = root
        for (s<-senate) {
            val n = new Node(s)
            p.next = n
            p = n
        }
        p.next = root.next
        var balance = 0
        while (p.next != p) {
            val x = p.next
            //println(balance, x.s, x.count)
            if (x.s == p.s) {
                p.count += x.count
                balance += x.influence
                p.next = x.next
            } else {
                balance += x.influence
                if (x.isMajority(balance)) {
                    x.count = scala.math.abs(balance)
                    p = x
                } else {
                    p.next = x.next
                }
            }
        }
        if (p.s == 'R') "Radiant" else "Dire"
    }
}

class Node(val s: Char) {
    var next: Node = null
    var count = 1
    def influence : Int = if (s=='R') count else -count
    def isMajority(balance: Int) : Boolean = {
        if (balance == 0) return false
        (balance < 0) ^ (s == 'R')
    }
}