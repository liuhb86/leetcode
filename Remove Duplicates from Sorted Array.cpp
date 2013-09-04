class Solution {
public:
    int removeDuplicates(int A[], int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if ( A== NULL) return 0;
        
        int *src=A, *dest = A, *end = A+n;
        
        while(src!=end) {
            int value = *(src++);
            *(dest++) = value;
            while(src!=end && *src==value) ++src;
        }
        return dest-A;
    }
};