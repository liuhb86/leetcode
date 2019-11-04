/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        int y = 1000;
        for (int x=1; x<=1000; x+=1) {
            int t = customfunction.f(x,y);
            while (t>z) {
                if (y==1) return result;
                y -= 1;
                t = customfunction.f(x,y);
            }
            if (t==z) {
                List<Integer> e = new ArrayList<>();
                e.add(x); e.add(y);
                result.add(e);
            }
        }
        return result;
    }
}