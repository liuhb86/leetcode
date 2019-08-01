import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<List<Integer>>> lists = new ArrayList();
        for (int i = 0; i < nums.length; i+=1) {
            int n = nums[i];
            int start = map.getOrDefault(n, 0) ;
            List<List<Integer>> x = new ArrayList<>();
            for (int j = start; j < i; j +=1) {
                if (n >= nums[j]) {
                    List<List<Integer>> list = lists.get(j);
                    for (List<Integer> y : list) {
                        List<Integer> z = new ArrayList<>(y);
                        z.add(n);
                        x.add(z);
                        r.add(z);
                    }
                }
            }
            if (!map.containsKey(n)) {
                List<Integer> single = new ArrayList();
                single.add(n);
                x.add(single);
            }
            map.put(n, i);
            lists.add(x);
        }
        return r;
    }
}

