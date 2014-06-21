/* ref:
bool search(int A[], int n, int key) {
    int l = 0, r = n - 1;
    while (l <= r) {
        int m = l + (r - l)/2;
        if (A[m] == key) return true; //return m in Search in Rotated Array I
        if (A[l] < A[m]) { //left half is sorted
            if (A[l] <= key && key < A[m])
                r = m - 1;
            else
                l = m + 1;
        } else if (A[l] > A[m]) { //right half is sorted
            if (A[m] < key && key <= A[r])
                l = m + 1;
            else
                r = m - 1;
        } else l++;
    }
    return false;
}
*/
class Solution {
public:
    bool search(int A[], int n, int target) {
        int* begin = A;
        int* end = A+n-1;
        while (begin<=end) {
            int* mid = begin + (end-begin)/2;
            if (*mid==target) return true;
            if (*begin<*mid) {
                if (target>=*begin && target<*mid)
                {
                    end = mid - 1;
                }
                else
                {
                    begin = mid + 1;
                }
            } else if (*begin>*mid) {
                if (target>*mid && target<=*end) {
                    begin = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            } else {
                ++begin;
            }
        }
        return false;
    }
};
