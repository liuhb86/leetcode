class Solution {
public:
    vector<int> findSubstring(string S, vector<string> &L) {
        vector<int> result;
        if (L.empty()) return result;
        unordered_map<string, int> hash;
        vector<int> count;
        vector<int> occur;
        deque<int> sequence;
        
        for (int i=0;i<L.size();++i) {
            unordered_map<string, int>::iterator it = hash.find(L[i]);
            if (it!=hash.end()) {
                ++count[it->second];
            } else {
                int index = count.size();
                count.push_back(1);
                occur.push_back(0);
                hash[L[i]] = index;
            }
        }
        
        int wordLength=L.back().size();
        for (int offset=0; offset<wordLength;++offset) {
            sequence.clear();
            occur.assign(occur.size(), 0);
            for (int i=offset;i+wordLength<=S.size();i+=wordLength) {
                unordered_map<string, int>::iterator it= hash.find(S.substr(i, wordLength));
                if (it==hash.end()) {
                    sequence.clear();
                    occur.assign(occur.size(), 0);
                } else {
                    int index = it->second;
                    if (occur[index] == count[index]) {
                        while(true) {
                            int front = sequence.front();
                            sequence.pop_front();
                            --occur[front];
                            if (front == index) break;
                        }
                    }
                    sequence.push_back(index);
                    ++occur[index];
                    if (sequence.size()==L.size()) {
                        result.push_back(i-(L.size()-1)*wordLength);
                    }
                }
            }
        }
        
        return result;
    }
};