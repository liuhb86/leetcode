class Solution {
public:
    int ladderLength(string start, string end, unordered_set<string> &dict) {
        const char* pStart = start.c_str();
        const char* pEnd = end.c_str();
        int d = diff(pStart, pEnd);
        if (d<2) return d + 1;
        
        int length = 0;
        deque<const char*> que;
        que.push_back(pStart);
        int size = 1;
        set<const char*> unvisited;
         for (unordered_set<string>::iterator it = dict.begin(); it!=dict.end(); ++it) {
            if (*it != end) unvisited.insert(it->c_str());
        }
        
        while(!que.empty()) {
            const char* s = que.front();
            que.pop_front();
            int d = diff(s, pEnd);
            if (d == 1) return length + 1 + 1;
            for (set<const char*>::iterator it = unvisited.begin(); it != unvisited.end();) {
                if (diff(s, *it) < 2) {
                    que.push_back(*it);
                    unvisited.erase(it++);
                }
                else {
                    ++it;
                }
            }
            --size;
            if (size == 0) {
                ++length;
                size = que.size();
            }
        }
        
        return 0;
    }
    
    int diff(const char* s, const char* t) {
        int d = 0;
        while(*s!=0) {
            if (*s!=*t) {
                ++d;
                if (d >=2) return d;
            }
            ++s;
            ++t;
        }
        return d;
    }
};
