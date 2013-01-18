class Solution {
public:
    //Ref: http://www.cnblogs.com/codingmylife/archive/2012/09/05/2671548.html
    int maxArea(vector<int> &height) {
       int i=0, j= height.size()-1;
       int maxA = 0;
       while(i<j){
           int m = min(height[i],height[j]);
           int area = (j-i)*m;
           if (area>maxA) maxA=area;
           if (height[i]<height[j]){
               ++i;
           } else {
               --j;
           }
       }
       return maxA;
    }
};