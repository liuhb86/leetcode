/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = peakIndexInMountainArray(mountainArr);
        //System.out.println(peak);
        int r1 = find(target, 0, peak + 1, mountainArr, true);
        if (r1 >=0) return r1;
        return find(target, peak+1, mountainArr.length(), mountainArr, false);
            
    }
    
    public int find(int target, int l, int r, MountainArray a, boolean inc) {
        while (l < r) {
            int mid = (l + r - 1) / 2;
            //if (!inc) System.out.println(mid);
            int v = a.get(mid);
            if (v == target) return mid;
            if ((v < target && inc) || (v>target && !inc)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
    
    public int gold1(int l, int r, MountainArray a) {
        return l + (int)Math.round((r - l) * 0.382);
    }
    
    public int gold2(int l, int r, MountainArray a) {
        return l + (int)Math.round((r - l) * 0.618);
    }
    
    // Golden-section search
    // https://en.wikipedia.org/wiki/Golden-section_search
    public int peakIndexInMountainArray(MountainArray a) {
        int l = 0;
        int r = a.length() -1;
        int x1 = gold1(l,r,a);
        int x2 = gold2(l,r,a);
        while (x1 < x2) {
            if (a.get(x1) < a.get(x2)) {
                l = x1;
                x1 = x2;
                x2 = gold1(x1, r,a);
            } else{
                r = x2;
                x2 = x1;
                x1 = gold2(l, x2,a);
            }
        }
        return x1;
    }
}