class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLen = 0;
        int charHash[300];
        int start = -1;
        int len = 0;
        memset(charHash,-1,sizeof(charHash));
        for (int i=0; i<s.size(); ++i) {
            char c = s.at(i);
            int loc = charHash[c];
            if (loc<0){
                ++len;
                if (len>maxLen) maxLen=len;
            } else {
                for(int j=start+1;j<loc;++j)
                    charHash[s.at(j)]=-1;
                start = loc;
                len = i-loc;
            }
            charHash[c]=i;
        }
        return maxLen;
    }
};