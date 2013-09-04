class Solution {
public:
    char *strStr(char *haystack, char *needle) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (needle == NULL) return NULL;
        int len = strlen(needle);
        if (len == 0 ) return haystack;
        
        int *T = new int[len];
        T[0] = -1;
        if (len>1) T[1] = 0;
        int pos = 2, cnd =0;
        
        while(pos<len) {
            if (needle[pos-1]==needle[cnd]) {
                ++cnd;
                T[pos]=cnd;
                ++pos;
            } else if (cnd>0) {
                cnd = T[cnd];
            } else {
                T[pos]= 0;
                ++pos;
            }
        }
        
        int m = 0, i = 0;
        int length = strlen(haystack);
        
        while(m+i<length) {
            if (haystack[m+i] ==needle[i]) {
                if (i==len-1) {
                    delete T;
                    return haystack + m;
                }
                ++i;
            } else {
                m = m + i - T[i];
                if (T[i]>-1) i = T[i]; else i = 0; 
            }
        }
        
        delete T;
        return NULL;
    }
};