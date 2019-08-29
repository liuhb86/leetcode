class Solution {
    public int search(ArrayReader reader, int target) {
        int begin = 0;
        int end = 20000;
        if (reader.get(end) == target) return end;
        if (target > 10000) return -1;
        while (begin < end) {
            int mid = begin + (end-begin) / 2;
            int v = reader.get(mid);
            if (v==target) return mid;
            else if (v > target) end = mid;
            else begin = mid + 1;
        }
        return -1;
    }
}