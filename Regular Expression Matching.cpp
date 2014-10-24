//Ref:
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        if (!*p && !*s) return true;
        if (!*p) return false;
        if (*(p+1)=='*') {
            while(*p=='.'&& *s || *p==*s) {
                if (isMatch(s,p+2)) return true;
                ++s;
            }
            return isMatch(s,p+2);
        } else if (*p=='.'&&*s || *p==*s) {
            return isMatch(s+1,p+1);
        }
        return false;
    }
};