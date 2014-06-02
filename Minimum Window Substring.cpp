class Solution {
public:
    string minWindow(string S, string T) {
        string result;
        if (T.empty()) return result;
        int sChars[256] = {0};
        int nChar = 0;
        for (int i=0;i<T.size();++i) {
            ++nChar;
            ++sChars[T[i]];
        }
        int loc[256]={0};
        deque<int> q;
        int minLen = -1, minBegin=-1;
        int charLeft = nChar;
        for(int i=0;i<S.size();++i) {
            bool needPop = false;
            char c =S[i];
            if (sChars[c]==0) continue;
            ++(loc[c]);
            q.push_back(i);
            if (loc[c]<=sChars[c]) {
                --charLeft;
                if (charLeft==0) {
                    int len = i - q.front() + 1;
                    if (minLen<0 || len<minLen) {
                        minLen = len;
                        minBegin = q.front();
                        if (len==nChar) break;
                    }
                    ++charLeft;
                    needPop = true;
                }
            } else if (S[q.front()]==c) {
                needPop = true;
            }
            if (needPop) {
                do {
                    --(loc[S[q.front()]]);
                    q.pop_front();
                } while(!q.empty() && loc[S[q.front()]] > sChars[S[q.front()]]);
            }
        }
        if (minLen < 0) return result;
        result.append(S.begin()+minBegin, S.begin() +(minBegin +minLen));
        return result;
    }
    static void main() {
	    Solution s;
	    cout<<s.minWindow("aa","aa");
    }
};
