class Solution {
public:
    int search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n==0) return -1;
        int* head = searchHead(A, A+n);
        int last = A[n-1];
        int* result;
        if (target == last) return (n-1);
        else if (target < last){
            result = find(head, A+(n-1), target);
            if (result!=A+(n-1)) return result-A; else return -1;
        }
        else
        {
            result = find(A,head, target);
            if (result!=head) return result-A; else return -1;
        }
        
    }
private:
    int* searchHead(int* begin, int* end)
    {
        if (end <= begin) return end;
        if (*begin <= *(end-1)) return begin;
        int* middle = begin+(end-begin)/2;
        if (*(middle-1) >= *begin){
            return searchHead(middle, end);
        }
        else {
            return searchHead(begin, middle);
        }
    }
};