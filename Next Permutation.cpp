typedef vector<int>::reverse_iterator It;

class Solution {
public:
    void nextPermutation(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int n = num.size();
        
        if (n<=1) return;
        int i,j, t;
        for (i=n-2;i>=0;--i){
            if (num[i]<num[i+1]) break;
        }
        if (i>=0) {
           for(j=n-1;;j--) {
               if (num[j]>num[i]) break;
           }
           t = num[i]; num[i]=num[j]; num[j]= t;
        }
        t = num[n-1];
        i = i+1; j=n-1;
        while(i<j){
            t = num[i];
            num[i]=num[j];
            num[j]=t;
            ++i;--j;
        }
    }
};