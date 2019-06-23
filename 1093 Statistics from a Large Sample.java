class Solution {
  public double[] sampleStats(int[] count) {
    int min;
    for (int i= 0;;i +=1) {
      if (count[i] > 0) { min = i; break;}
    }
    int max;
    for (int i=count.length -1;; i-= 1) {
      if (count[i] > 0) {max = i; break;}
    }
    int mode = min;
    int modec = count[min];
    int c = 0;
    long sum = 0;
    for (int i= min; i<= max; i+=1) {
      int ct = count[i];
      c += ct;
      sum += ((long) i) * ct;
      if (count[i] > modec) {mode = i; modec = count[i];}
    }
    double mean = sum / (double) c;
    int median1 = -1;
    int median2;
    if (c%2 == 1) {
      int k = c / 2 + 1;
      int t = 0;
      for (int i=min;; i+=1) {
        t += count[i];  
        if (t >= k) {median1=i;median2=i;break;}
      }
    } else {
      int k = c / 2;
      int t = 0;
      for (int i=0;; i+=1) {
        t += count[i];
        if (t>=k) {
          if (median1 < 0) {
            if (t>k) {median1=i;median2=i;break;}
            median1 = i;
            k += 1;
          } else {
            median2 = i;
            break;
          }
        }
      }
    }
    double median = (median1 + median2) / 2.0;
    double r[] = {min, max, mean, median, mode};
    return r;
  }
}