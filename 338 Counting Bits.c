/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* countBits(int num, int* returnSize){
    *returnSize = num+1;
    int* r = (int*) malloc((num+1)*sizeof(int));
    int d = 1, nd = 2;
    r[0] = 0;
    for (int i = 1; i<= num; ++i) {
        if (i == nd) {
            r[i] = 1;
            d = nd;
            nd <<=1;
        } else {
            r[i] = r[i-d] + 1;
        }
    }
    return r;
}

