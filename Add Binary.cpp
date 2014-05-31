class Solution {
public:
    string addBinary(string a, string b) {
        string result;
        char c = 0;
        int la = a.size();
        int lb = b.size();
        int l = max(la,lb);
        result.reserve(l+1);
        for (int i=0;i<l;++i)
        {
            if (la>0) c+= (a[--la]-'0');
            if (lb>0) c+= (b[--lb]-'0');
            result.push_back(sr[c]);
            c = sc[c];
        }
        if (c>0) result.push_back('0'+c);
        std::reverse(result.begin(), result.end());
        return result;
    }
private:
    static char sr[4];
    static char sc[4]; 
};

char Solution::sr[4]={'0','1','0','1'};
char Solution::sc[4]={0,0,1,1};
