
class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
        vector<string> result;
        if (words.empty()) return result;
        int nWords = words.size();
        int bWord = 0;
        while(bWord<nWords) {
            int eWord = bWord + 1;
            int len = words[bWord].size() + 1;
            while(eWord<nWords)
            {
                int l = words[eWord].size();
                if (len+l>L) break;
                len += (l + 1);
                ++eWord;
            }
            --len;
            int nGap = eWord-bWord-1;
            int extraSpace = L - len;
            result.push_back(string());
            string& curLine = result.back();
            int padding;
            int extraPadding;
            if (eWord == nWords || nGap == 0) {
                padding = 0;
                extraPadding = 0;
            }
            else
            {
                padding = extraSpace/nGap;
                extraPadding = extraSpace % nGap;
                extraSpace = 0;
            }
            
            curLine.append(words[bWord++]);
            while (bWord < eWord)
            {
                int nSpace = 1 + padding;
                if (extraPadding > 0)
                {
                    ++nSpace;
                    --extraPadding;
                }
                curLine.append(nSpace, ' ');
                curLine.append(words[bWord++]);
            }
            if (extraSpace > 0) curLine.append(extraSpace,' ');
        }
        return result;
    }
    static void main()
    {
	    const char* pword[] = {"This", "is", "an", "example", "of", "text", "justification."};
	    int nWord = sizeof(pword)/sizeof(const char*);
	    vector<string> words;
	    for (int i=0;i<nWord;++i) words.push_back(pword[i]);
	    Solution s;
	    vector<string> r = s.fullJustify(words, 16);
	    for (int i=0;i<r.size();++i) cout<<r[i]<<endl;
    }
};
