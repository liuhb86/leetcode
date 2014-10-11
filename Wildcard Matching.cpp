class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        const char* starMatchSrc = NULL;
        const char* starMatchPattern;
        while(*s) {
            if (*p=='?' || *s==*p) {
                ++s; ++p;
            } else if (*p=='*') {
                starMatchSrc = s;
                starMatchPattern = p+1;
                ++p;
            } else if (starMatchSrc) {
                s = ++starMatchSrc;
                p = starMatchPattern;
            } else {
                return false;
            }
        }
        
        while(*p=='*') ++p;
        return *p=='\0';
    }
};