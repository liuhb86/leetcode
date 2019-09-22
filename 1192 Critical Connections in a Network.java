// peek
// tarjan
// https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
// https://www.geeksforgeeks.org/bridge-in-a-graph/
class Solution {
    static int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer> edges[] = (List<Integer>[]) new ArrayList[n];
        for (int i=0; i<n; i+=1) edges[i] = new ArrayList<Integer>();
        for (List<Integer> e: connections) {
            edges[e.get(0)].add(e.get(1));
            edges[e.get(1)].add(e.get(0));
        }
        int visitTime[] = new int[n];
        int parent[] = new int[n];
        int minParentTime[] = new int[n];
        time = 0;
        List<List<Integer>> r = new ArrayList<>();
        tarjan(0, edges, visitTime, parent, minParentTime, r);
        return r;
    }
    
    void tarjan(int i, List<Integer>[] edges, int[] visitTime, int[] parent,
            int[] minParentTime, List<List<Integer>> r) {
        time += 1;
        visitTime[i] = time;
        minParentTime[i] = time;
        List<Integer> children = edges[i];
        for (int c: children) {
            if (visitTime[c] == 0) {
                parent[c] = i;
                tarjan(c, edges, visitTime, parent, minParentTime, r);
                if (minParentTime[c] < minParentTime[i]) minParentTime[i] = minParentTime[c];
                if (minParentTime[c] > visitTime[i]) {
                    List<Integer> e = new ArrayList();
                    e.add(i); e.add(c); r.add(e);
                }
            } else if (parent[i] != c) {
                if (minParentTime[c] < minParentTime[i]) minParentTime[i] = minParentTime[c];
            }
        }
    }
}