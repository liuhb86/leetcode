class Solution {
public:
    int findK(int* aBegin, int* aEnd, int* bBegin, int* bEnd, int k) {
        if (aBegin>=aEnd) return bBegin[k];
        if (bBegin>=bEnd) return aBegin[k];
        if (aEnd-aBegin<bEnd-bBegin){
            int* tmp;
            tmp=aBegin;aBegin=bBegin; bBegin=tmp;
            tmp=aEnd; aEnd=bEnd; bEnd=tmp;
        }
        int* aMiddle = aBegin+(aEnd-aBegin)/2;
        int middle = *aMiddle;
        int* bMiddle = upper_bound(bBegin,bEnd, middle);
        int position = aMiddle-aBegin + (bMiddle-bBegin);
        if (position ==k) return middle;
        else if (position>k)
            return findK(aBegin,aMiddle,bBegin,bMiddle,k);
        else
            return findK(aMiddle+1,aEnd,bMiddle,bEnd,k-position-1);
    }
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        if ((m+n)%2==1) return findK(A,A+m,B,B+n,(m+n)/2);
        else {
            double m1=findK(A,A+m,B,B+n,(m+n)/2-1);
            double m2 = findK(A,A+m,B,B+n,(m+n)/2);
            return (m1+m2)/2;
        }
    }
};