object Solution {
    def checkValidString(s: String): Boolean = {
        check(s) && check(reverse(s))
    }
    
    def check(s: String) : Boolean = {
        var p = 0
        var a = 0
        for (c<-s) {
            c match {
                case '(' => p+=1
                case ')' => 
                    if (p>0) p-=1
                    else if (a>0) a-=1
                    else return false
                case '*' => a+=1
            }
        }
        true
    }
    
    def reverse(s: String) : String = {
        s.reverse.map{
            case '(' => ')'
            case ')' => '('
            case x => x
        }
    }
}