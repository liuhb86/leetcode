class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        if (strs.empty()) return "";
        int len=0;
        while(true){
            bool conti = true;
            bool first = true;
            char c;
            for(vector<string>::iterator it=strs.begin(); it!=strs.end();++it){
                if(it->size()==len) {conti=false;break;}
                if(first) {
                    first = false;
                    c = it->at(len);
                } else {
                    if (c!=it->at(len)){conti=false;break;}
                }
            }
            if (!conti) break;
            ++len;
        }
        return strs[0].substr(0,len);
    }
};