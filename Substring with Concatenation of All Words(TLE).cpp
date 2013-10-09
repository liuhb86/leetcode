// leetcode.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <vector>
#include <set>
#include <iostream>
#include <string>
using namespace std;
class Solution {
public:
    vector<int> findSubstring(string S, vector<string> &L) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        
        vector<int> result;
        multiset<string> L_set;
        for(vector<string>::iterator it = L.begin(); it!=L.end(); ++it) L_set.insert(*it);
        multiset<string> current;
        int wordLen = L[0].size();
        
        for (int i=0;i<wordLen;++i) {
            int start = i;
            int pos = i;
            current.clear();
            while(pos + wordLen <= S.size()){
                string s = S.substr(pos,wordLen);
                pos += wordLen;
                if (L_set.count(s) == 0) {
                    current.clear();
                    start = pos;
                } else {
                    if (current.count(s) < L_set.count(s)) {
                        current.insert(s);
                    } else {
                        while(true){
                            string t = S.substr(start,wordLen);
                            start += wordLen;
                            if (t.compare(s)==0) break;
                            current.erase(current.find(t));
                        }
                    }
                    
                    if (current.size()==L_set.size()) {
                        result.push_back(start);
                    }
                }
            }
        }
        
        return result;
    }
};

int _tmain(int argc, _TCHAR* argv[])
{
	string S("barfoothefoobarman");
	vector<string> L;
	L.push_back("foo"); L.push_back("bar");

	Solution sol;
	sol.findSubstring(S,L);
	return 0;
}

