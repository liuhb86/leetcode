class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parents = new HashMap<>();
        for (List<String> list : regions) {
            String parent = null;
            for (String region: list) {
                if (parent == null) {
                    parent = region;
                } else {
                    parents.put(region, parent);
                }
            }
        }
        int d1 = depth(region1, parents);
        int d2 = depth(region2, parents);
        if (d1 < d2) {
            int d = d1; d1 = d2; d2= d;
            String t = region1; region1 = region2; region2 = t;
        }
        while (d1 > d2) {
            region1 = parents.get(region1);
            d1 -= 1;
        }
        for (int i = 0; i <= d2; i+=1) {
            if (region1.equals(region2)) return region1;
            region1 = parents.get(region1);
            region2 = parents.get(region2);
        }
        throw new RuntimeException();
    }
    
    private int depth(String region, Map<String, String> parents) {
        int d = 0;
        region = parents.get(region);
        while (region != null) {
            d += 1;
            region = parents.get(region);
        }
        return d;
    }
}