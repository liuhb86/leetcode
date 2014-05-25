class Solution {
public:
    int lengthOfLastWord(const char *s) {
        const char* wordStart = s;
        while(*wordStart==' ') ++wordStart;
        const char* wordEnd;
        const char* p;
        bool space = false;
        for(p=wordStart;*p!='\0'; ++p)
        {
            if (*p==' ') {
                if (!space) {
                    space = true;
                    wordEnd = p;
                }
            }
            else if (space) {wordStart = p; space = false;}
        }
        if (!space) {
            wordEnd = p;
        }
        return wordEnd - wordStart;
    }
};