
class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Integer> gm = new HashMap<>();
        int ng = 0;
        ArrayList<Set<Integer>> cg = new ArrayList<>();
        for (int i=0; i<group.length; i++) {
            if (group[i] == -1) {
                group[i] = ng;
                ng += 1;
                Set<Integer> s = new HashSet<>();
                s.add(i);
                cg.add(s);
            } else {
                if (gm.containsKey(group[i])) {
                    int v = gm.get(group[i]);
                    group[i] = v;
                    cg.get(v).add(i);
                } else {
                    gm.put(group[i], ng);
                    group[i] = ng;
                    ng += 1;
                    Set<Integer> s = new HashSet<>();
                    s.add(i);
                    cg.add(s);
                }
            }
        }
        IntSet gpre[] = new IntSet[ng];
        IntSet gnext[] = new IntSet[ng];
        IntSet pre[] = new IntSet[n];
        IntSet next[] = new IntSet[n];
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j : beforeItems.get(i)) {
                int gi = group[i];
                int gj = group[j];
                if (gi == gj) {
                    if (pre[i] == null) pre[i] = new IntSet();
                    if (next[j]== null) next[j] = new IntSet();
                    pre[i].add(j);
                    next[j].add(i);
                } else {
                    if (gpre[gi]== null) gpre[gi] = new IntSet();
                    if (gnext[gj] == null) gnext[gj] = new IntSet();
                    gpre[gi].add(gj);
                    gnext[gj].add(gi);
                }
            }
        }
        
        List<Integer> glist = new ArrayList<>();
        for (int i = 0; i<ng; i++) {
            if (gpre[i] == null) glist.add(i);
        }
        int groupLeft = ng;
        List<Integer> r = new ArrayList<>();
        while(!glist.isEmpty()) {
            List<Integer> gnlist = new ArrayList<>();
            for (int g : glist) {
                groupLeft -= 1;
                
                List<Integer> list = new ArrayList<>();
                for (int i:cg.get(g)) {
                    if (pre[i] == null) list.add(i);
                }
                int left = cg.get(g).size();
                while (!list.isEmpty()) {
                    List<Integer> nlist = new ArrayList<>();
                    for (int p : list) {
                        left -=1;
                        r.add(p);
                        if (next[p] != null) {
                            for (int x : next[p]) {
                                pre[x].remove(p);
                                if (pre[x].isEmpty()) {
                                    nlist.add(x);
                                }
                            }
                        }
                    }
                    list = nlist;
                }
                if (left > 0) return new int[0];
                
                if (gnext[g] != null) {
                    for (int x : gnext[g]) {
                        gpre[x].remove(g);
                        if (gpre[x].isEmpty()) {
                            gnlist.add(x);
                        }
                    }
                }
            }
            glist = gnlist;
        }
        if (groupLeft !=0) return new int[0];
        int[] rr = new int[r.size()];
        for (int i = 0; i<r.size(); i++) {
            rr[i] = r.get(i);
        }
        return rr;
    }
}

class IntSet extends HashSet<Integer> {
    
}
