class Solution {
public:
    int trap(int A[], int n) {
        if (n==0) return 0;
        int* pLeft = A;
        int* pRight = A+n-1;
        int volume = 0;
        while (pLeft<pRight)
        {
            if (*pLeft<*pRight)
            {
                int H = *pLeft;
                int* p;
                for(p=pLeft+1;p<pRight;++p)
                {
                    int h = *p;
                    if (h>=H) break;
                    volume += (H-h);
                }
                pLeft = p;
            }
            else
            {
                int H = *pRight;
                int* p;
                for(p=pRight-1;p>pLeft;--p)
                {
                    int h = *p;
                    if (h>=H) break;
                    volume += (H-h);
                }
                pRight = p;
            }
        }
        return volume;
    }
};