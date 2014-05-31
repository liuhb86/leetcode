class Solution {
public:
    string simplifyPath(string path) {
        string result;
        if (path.size()==0) return result;
        string::iterator s = path.begin();
        vector<string> vPath;
        bool isAbs = false;
        int iStart = 0;
        if (path[iStart]=='/') {
            ++iStart;
            isAbs = true;
        }
        int pEnd = path.size();
        if (path[pEnd-1]=='/') --pEnd;
        for (int iEnd=iStart;iEnd<=pEnd;++iEnd) {
            if (iEnd==pEnd || path[iEnd]=='/') {
                if (iEnd==iStart || (iEnd-iStart==1 && path[iStart]=='.')) {
                    // do thing
                } else if (iEnd-iStart==2 && path[iStart]=='.' && path[iStart+1]=='.') {
                    if (!vPath.empty()) vPath.pop_back();
                } else {
                    vPath.push_back(string(s+iStart, s+iEnd));
                }
                iStart=iEnd+1;
            }
        }
        if (isAbs) result.append(1,'/');
        for (int i=0;i<vPath.size();++i) {
            if (i>0) result.append(1,'/');
            result.append(vPath[i]);
        }
        return result;
    }
};
