#include <cstring>
#include <algorithm>
#include <iostream>
using namespace std;

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        const char* patternBegin = p;
        const char* patternEnd = p + strlen(p);
        const char* sEnd = s + strlen(s);
        if (patternBegin>=patternEnd) return (s==sEnd);
        if (*(patternEnd-1)!='*')
        {
            const char* lastPattern = patternEnd-1;
            while(lastPattern >=patternBegin && *lastPattern!='*') --lastPattern;
            ++lastPattern;
            if (!compare_reverse(s,sEnd,lastPattern, patternEnd)) return false;
            sEnd = sEnd -(patternEnd-lastPattern);
            patternEnd = lastPattern;
            if (patternBegin>=patternEnd)
            {
                return (s==sEnd);
            }
        }

        if (*patternBegin!='*')
        {
            const char* firstPatternEnd = patternBegin;
            while(firstPatternEnd <patternEnd && *firstPatternEnd!='*') ++firstPatternEnd;
            if (!compare(s,sEnd,patternBegin,firstPatternEnd)) return false;
            s = s + (firstPatternEnd-patternBegin);
            patternBegin = firstPatternEnd;
        }

        while(patternBegin <patternEnd)
        {
            while(patternBegin<patternEnd && *patternBegin=='*') ++patternBegin;
            while(patternBegin<patternEnd && *patternBegin=='?')
            {
                ++patternBegin;
                ++s;
            }
            if (s>sEnd) return false;
            if (patternBegin >=patternEnd) return true;
            if (*patternBegin =='*')
            {
                ++patternBegin;
                continue;
            }
            const char* pNeedleEnd = patternBegin;
            while(*pNeedleEnd!='*' && *pNeedleEnd!='?') ++pNeedleEnd;
            const char* pSubPatternEnd = pNeedleEnd;
            while(*pSubPatternEnd!='*') ++pSubPatternEnd;
            const char* pMatched;
            bool lbFound = false;
            if (pSubPatternEnd == pNeedleEnd)
            {
                pMatched = search(s,sEnd, patternBegin,pNeedleEnd);
                lbFound = (pMatched != sEnd);
            }
            else
            {
                int nNeedleLen = pNeedleEnd - patternBegin;
                while (s<=sEnd)
                {
                    pMatched = search(s,sEnd, patternBegin,pNeedleEnd);
                    if (pMatched==sEnd) return false;
                    if (compare(pMatched+nNeedleLen, sEnd, pNeedleEnd,pSubPatternEnd))
                    {
                        lbFound = true;
                        break;
                    }
                    s = pMatched + 1;
                }
            }
            if (!lbFound) return false;
            s = pMatched + (pSubPatternEnd-patternBegin);
            patternBegin = pSubPatternEnd;
        }
        return true;
    }
    static void main()
    {
        const char* s="ab";
        const char* p="*a";
        Solution sol;
        cout<<sol.isMatch(s,p);
    }
private:
    bool compare(const char* s, const char* sEnd,const char* pattern, const char* patternEnd)
    {
        if (sEnd-s < patternEnd-pattern) return false;
        for (;pattern<patternEnd;++pattern, ++s)
        {
            if (*pattern=='?') continue;
            if (*pattern != *s) return false;
        }
        return true;
    }
       bool compare_reverse(const char* s, const char* sEnd,const char* pattern, const char* patternEnd)
    {
        if (sEnd-s < patternEnd-pattern) return false;
        sEnd = sEnd-1;
        for (patternEnd=patternEnd-1;patternEnd>=pattern;--patternEnd, --sEnd)
        {
            if (*patternEnd=='?') continue;
            if (*patternEnd != *sEnd) return false;
        }
        return true;
    }
};
