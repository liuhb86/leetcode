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
        bool operator<(const Slope& that) const {
            if (dx == 0 && that.dx !=0) return true;
            if (that.dx ==0) return false;
            if (dx*that.dx<0) return dy*that.dx < that.dy * dx;
            return dy* that.dx > that.dy * dx;
        }
    };
public:
    int maxPoints(vector<Point> &points) {
        int mp = 0;
        for (int i=0;i<points.size();++i) {
            int p = 0;
            int ms = 0;
            map<Slope, int> slopes;
            for (int j=0;j<points.size(); ++j) {
                if (points[i].x==points[j].x && points[i].y ==points[j].y) {++p; continue;}
                Slope s;
                s.dx = points[i].x - points[j].x;
                s.dy = points[i].y - points[j].y;
                int& count = slopes[s];
                ++count;
                if (count > ms) ms = count;
            }
            int count = p + ms;
            if (count > mp) mp = count;
        }
        return mp;
    }
};