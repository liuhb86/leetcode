class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        map<string, vector<string> > anagramMap;
        for (vector<string>::iterator it = strs.begin(); it!= strs.end(); ++it) {
            string s = *it;
            sort(s.begin(), s.end());
            anagramMap[s].push_back(*it);
        }
        vector<string> result;
        for (map<string, vector<string> >::iterator it = anagramMap.begin(); it!=anagramMap.end(); ++it)
        {
            vector<string>& vec = it->second;
            if (vec.size() > 1)
            {
                for (vector<string>::iterator iit = vec.begin(); iit != vec.end(); ++iit) {
                    result.push_back(*iit);
                }
            }
        }
        return result;
    }
private:

};