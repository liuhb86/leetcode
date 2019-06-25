object Solution {
    var s : String = _
    var i : Int = _
    def isValid(code: String): Boolean = {
        try {
            s = code
            i = 0
            tag() && i == s.length
        } catch {
            case e: StringIndexOutOfBoundsException => false
        }
    }
    
    def tag() : Boolean = {
        if (s(i)!='<') return false
        i+=1
        val name = tagName()
        if (name == null) return false
        while(s(i)!= '<' || s(i+1) != '/') {
            if (s(i) =='<') {
                val r = if (s(i+1) == '!') cdata() else tag()
                if (!r) return false
            } else {
                i+=1
            }     
        }
        i+=2
        val closeName = tagName()
        closeName == name
    }
    
    def tagName() : String = {
        val start = i
        var l = 0
        while (s(i).isUpper && l<9) {
            i+=1; l+=1;
        }
        if (l == 0) return null
        if (s(i)!='>') return null
        i+=1
        s.substring(start, start + l)
    }
    
    def cdata() : Boolean = {
        if (s.substring(i, i+9)!="<![CDATA[") return false
        i+=9
        while (s(i)!=']' || s(i+1)!=']' || s(i+2)!='>') i+=1
        i+=3
        true
    }
}