class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        int lenRegex=strlen(p);
        set<int> loc1;
        set<int> loc2;
        set<int>* loc = &loc1;
        set<int>* locNext = &loc2;
        loc->insert(0);
        for(;;++s){
            if(loc->empty()) return false;
            locNext->clear();
            for(set<int>::iterator it=loc->begin(); it!=loc->end();++it){
                int i=*it;
                while (i!=lenRegex && p[i+1]=='*') {
                    if (p[i]=='.' || p[i]==*s){
                        locNext->insert(i);
                        locNext->insert(i+2);
                    }
                    i+=2;
                }
                if (p[i]=='.' || p[i]==*s){
                    locNext->insert(i+1);
                }
            }
            set<int>* tmp = loc;
            loc=locNext;
            locNext = tmp;
            if (*s=='\0') break;
        }
        if(loc->count(lenRegex+1)!=0) return true;
        else return false;
        
    }
};