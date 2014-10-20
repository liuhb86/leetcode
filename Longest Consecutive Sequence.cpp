class Solution {
    
    typedef unordered_map<int, int> HashMap;
    
public:
    int longestConsecutive(vector<int> &num) {
        HashMap hash;
        int longest = 0;
        for (vector<int>::iterator it = num.begin(); it!= num.end(); ++it) {
            int n = *it;
            HashMap::iterator r;
            r = hash.find(n);
            if (r!= hash.end()) continue;
            HashMap::iterator rl = hash.find(n-1);
            HashMap::iterator rr = hash.find(n+1);
            int len = 1;
            if (rl!=hash.end() && rr != hash.end()) {
                int ll = rl->second;
                int lr = rr->second;
                len = ll + lr + 1;
                hash[n - ll] = len;
                hash[n+lr] = len;
            } else if (rl != hash.end()) {
                int ll = rl->second;
                len = ll + 1;
                hash[n-ll] = len;
            } else if (rr != hash.end()) {
                int lr = rr->second;
                len = lr + 1;
                hash[n+lr] = len;
            }
            
            hash[n] = len;
            
            if (len > longest) longest = len;
        }
        return longest;
    }
};
