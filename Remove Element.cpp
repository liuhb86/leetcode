class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (A == NULL) return 0;
        
        int  * src = A, *dest = A, *end = A+n;
        while (src!=end){
            int v = *(src++);
            if (v!=elem) *(dest++) = v; 
        }
        return dest - A;
        
    }
};