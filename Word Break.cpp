class Solution {
public:
    bool wordBreak(string s, unordered_set<string> &dict) {
        unordered_map<string, bool> cache;
        for (unordered_set<string>::iterator it = dict.begin(); it!=dict.end();++it) {
            cache[*it] = true;
        }
        return wordBreak(s, cache);
    }
    
    bool wordBreak(string s, unordered_map<string, bool>& cache) {
        unordered_map<string, bool>::iterator it = cache.find(s);
        if (it!=cache.end()) return it->second;
        for (int i=1;i<=static_cast<int>(s.size())-1;++i) {
            if (wordBreak(s.substr(0,i), cache) 
                && wordBreak(s.substr(i), cache)) {
                    cache[s] = true;
                    return true;
                }
        }
        cache[s]=false;
        return false;
    }
};