class Solution {
public:
//Ref: http://www.csie.ntnu.edu.tw/~u91029/Palindrome.html#a3
    int expand(char* begin, char* end, char* center, int start){
        char* p=center-start-1;
        char* q=center+start+1;
        while(p>=begin && q<end){
            if (*p!=*q) break;
            --p;
            ++q;
        }
        return center-p-1;
    }
    
    string longestPalindrome(string s) {
        int len = 2*s.size()+1;
        char* chars = new char[len];
        for(int i=0,j=0;i<s.size();++i){
            chars[j++]=0;
            chars[j++]=s.at(i);
        }
        chars[len-1]=0;
        int* palinLen = new int[len];
        int maxLen =0 ,maxCenter=0;
        int furthest=0, furthestCenter=0;
        palinLen[0]=0;
        for(int i=1;i<len;++i){
            int palin;
            if (i>furthest){
                furthestCenter=i;
                palin=expand(chars, chars+len, chars+i, 0);
                furthest = i+palin;
            } else {
                int mirror = furthestCenter - (i-furthestCenter);
                int bound = i+palinLen[mirror];
                if (bound<furthest){
                    palin=palinLen[mirror];
                } else if (bound>furthest) {
                    palin = furthest - i;
                } else {
                    furthestCenter = i;
                    palin=expand(chars, chars+len, chars+i, palinLen[mirror]);
                    furthest = i + palin;
                }
            }
            palinLen[i] = palin;
            if (palin > maxLen) {
                maxLen = palin;
                maxCenter = i;
            }
        }
		delete[] chars;
		delete[] palinLen;
        int start = (maxCenter-maxLen)/2;
        int end = (maxCenter+maxLen)/2;
        int length = end-start;
        return s.substr(start,length);
    }
};