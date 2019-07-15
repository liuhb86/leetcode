

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* corpFlightBookings(int** bookings, int bookingsSize, int* bookingsColSize, int n, int* returnSize){
    *returnSize = n;
    int* r = (int*) malloc(sizeof(int) * n);
    memset(r, 0, sizeof(int)* n);
    for (int i=0; i< bookingsSize; ++i) {
        int s = bookings[i][0];
        int e = bookings[i][1];
        int c = bookings[i][2];
        r[s - 1] += c;
        if (e < n) r[e] -= c;
    }
    for (int i=1; i < n; ++i) {
        r[i] += r[i-1];
    }
    return r;
}

