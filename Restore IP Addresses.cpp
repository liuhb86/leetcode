class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> result;
        const char* str = s.c_str();
        int len = s.size();
        int sol[4];
        solve(str, str+len,0, sol, result);
        return result;
    }
    void solve(const char* begin, const char* end, int seg, int* sol, vector<string>& result) {
        if (seg == 3) {
            if (begin>=end || end-begin>3) return;
            if (end-begin>1 && *begin=='0') return;
            int num = atoi(begin, end);
            if (num>=256) return;
            ostringstream oss;
            oss<<sol[0]<<'.'<<sol[1]<<'.'<<sol[2]<<'.'<<num;
            result.push_back(oss.str());
            return;
        }
        int num = 0;
        const char* p = begin;
        while(p<end) {
            if (p>begin && *begin=='0') break;
            num = num * 10 + (*p - '0');
            if (num>=256) break;
            sol[seg] = num;
            solve(p+1,end,seg+1, sol, result);
            ++p;
        }
    }
    int atoi(const char* begin,const char* end) {
        int num = 0;
        for (const char* p = begin;p<end;++p) {
            num = num * 10 + (*p - '0');
        }
        return num;
    }
    
};
