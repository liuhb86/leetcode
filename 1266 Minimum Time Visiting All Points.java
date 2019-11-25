class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        int px = points[0][0];
        int py = points[0][1];
        for (int i = 1; i < points.length; i += 1) {
            int x = points[i][0];
            int y = points[i][1];
            result += Math.max(Math.abs(x-px), Math.abs(y-py));
            px = x;
            py = y;
        }
        return result;
    }
}