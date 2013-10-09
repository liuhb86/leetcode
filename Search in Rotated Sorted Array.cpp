class Solution {
public:
    int search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int *begin = A, *end=A+n;
        int *m = end;
        
        while(begin<end){
            if (end-begin == 1) {m=begin;break}
            int middle = begin + (end-begin)/2;
            if (*middle<*begin) {end =middle +1; begin = begin+1;}
            else if (*middle>*(end-1)) {begin = middle+1;}
            else break;
        }
        
        if (target>=*A) {begin=A;end=m;}
        else {begin=m;end=A+n;}
        
        while(begin<end) {
            int* middle = begin +(end-begin)/2;
            if (target == *middle) return middle -A;
            else if (target>*middle) begin = middle +1;
            else end = target;
        }
        
        return -1;
    }
    
};