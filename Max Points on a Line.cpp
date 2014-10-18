/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
class Solution {
    struct Slope {
        int dx;
        int dy;
        Slope(Point a, Point b) : dx(a.x-b.x), dy(a.y-b.y) {}
        bool operator<(const Slope& that) const {
            if (dx == 0 && that.dx !=0) return true;
            if (that.dx ==0) return false;
            if (dx*that.dx<0) return dy*that.dx < that.dy * dx;
            return dy* that.dx > that.dy * dx;
        }
    };
public:
    int maxPoints(vector<Point> &points) {
        int result = 0;
        for (int i=0;i<points.size();++i) {
            int originCount = 0;
            int maxSlopeCount = 0;
            map<Slope, int> slopes;
            for (int j=0;j<points.size(); ++j) {
                if (points[i].x==points[j].x && points[i].y==points[j].y) {++originCount; continue;}
                int& count = slopes[Slope(points[i], points[j])];
                ++count;
                if (count > maxSlopeCount) maxSlopeCount = count;
            }
            int count = originCount + maxSlopeCount;
            if (count > result) result = count;
        }
        return result;
    }
};