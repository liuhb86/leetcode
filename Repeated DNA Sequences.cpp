class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        vector<string> result;
        if (s.size() <10) return result;
        unsigned char t[128];
        char tr[5] = "ATGC";
        for (int i=0;i<4;++i) t[tr[i]] = i;
        
        unsigned int mask = (1<<20) -1;
        unsigned int k = 0;
        for (int i=0;i<9;++i) k=(k<<2) | t[s[i]];
        unordered_map<unsigned int, int> hashtable;
        for (size_t i=9; i<s.size();++i) {
            k=((k<<2) | t[s[i]]) & mask ;
            ++(hashtable[k]);
        }
       
        char str[11];
        str[10] = '\0';
        for (auto it=hashtable.begin(); it!=hashtable.end();++it) {
            if (it->second <= 1) continue;
            k = it->first;
            for(int i=9;i>=0;--i) {
                str[i] = tr[k&3];
                k>>=2;
            }
            result.push_back(str);
        }
        return result;
    }
};
