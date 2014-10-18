class Solution {
public:
    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        vector<string> result;
        unordered_map<string, vector<int> > cache;
        wordBreak(s, dict, cache);
        vector<string> path;
        setResult(s, cache, path, result);
        return result;
    }
    
    bool wordBreak(string s, unordered_set<string>& dict, 
        unordered_map<string, vector<int> >& cache) {
        
        unordered_map<string, vector<int> >::iterator itResult = cache.find(s);
        if (itResult!= cache.end()) return !itResult->second.empty();
        vector<int>& splits = cache[s];
        if (dict.find(s)!=dict.end()) splits.push_back(-1);
        
        for(int i=1; i<s.size();++i) {
            if (dict.find(s.substr(0,i)) != dict.end() 
                && wordBreak(s.substr(i), dict, cache)) {
                    splits.push_back(i);
                }
        }
        
        return !splits.empty();
    }
    
    void setResult(string s, unordered_map<string, vector<int> >& cache, vector<string>& path, vector<string>& result) {
        vector<int>& splits = cache[s];
        for (vector<int>::iterator it = splits.begin(); it!=splits.end(); ++it) {
            int len = *it;
            if (len <0) {
                string r;
                for (vector<string>::iterator it2 = path.begin(); it2!=path.end();++it2) {
                    r+=*it2;
                    r+=" ";
                }
                r+=s;
                result.push_back(r);
                continue;
            }
            
            path.push_back(s.substr(0,len));
            setResult(s.substr(len), cache, path, result);
            path.pop_back();
        }
    }
};