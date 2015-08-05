class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        int count[256] = {0};
        for (int i=0;i<s.size();++i) ++count[s[i]];
        for (int i=0;i<t.size();++i) --count[t[i]];
        for (char i='a'; i<='z'; ++i) if (count[i]!=0) return false;
        return true;
    }
};
