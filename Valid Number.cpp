class Solution {
public:
    bool isNumber(const char *s) {
        while (*s==' ') ++s;
        const char* e=s;
        while(*e!='\0' && *e!=' ') ++e;
        for (const char* t=e;*t!='\0';++t) if (*t!=' ') return false;
        return isExp(s,e);
    }
private:
    bool isExp(const char* s, const char* e) {
        if (s>=e) return false;
        const char* b;
        for (b=s;b!=e;++b) if (*b=='e' || *b=='E') break;
        if (b==e) return isReal(s,e);
        if (!isReal(s,b)) return false;
        ++b;
        if (isSign(*b)) ++b;
        return isInt(b,e);
    }
    
    bool isReal(const char* s, const char* e) {
        if (s>=e) return false;
        if (isSign(*s)) ++s;
        const char* b;
        for (b=s;b!=e;++b) if (*b=='.') break;
        if (b==e) return isInt(s,e);
        const char *prev=(b==s)? b+1: b-1;
        const char *next=b+1;
        bool hasDigit = false;
        if (b!=s)
        {
            if (!isInt(s,b)) return false;
            hasDigit = true;
        }
        ++b;
        if (b!=e)
        {
            if (!isInt(b,e)) return false;
            hasDigit = true;
        }
        return hasDigit;
    }
    
    bool isInt(const char* s, const char* e) {
        if (s>=e) return false;
        while(s<e)
        {
            if (!isDigit(*s)) return false;
            ++s;
        }
        return true;
    }
    
    inline bool isDigit(const char c) {
        return c>='0' && c<='9';
    }
    inline bool isSign(const char c) {
        return c=='+' || c=='-';
    }
};
