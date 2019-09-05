/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};
*/

class P {
    public int start;
    public int end;
    public int i;
    public int j;
    public P(int start, int end, int i, int j) {
        this.start = start;
        this.end = end;
        this.i = i;
        this.j = j;
    }
}

class LastStartComp implements Comparator<P> {
    @Override
    public int compare(P a, P b) {
        int c = Integer.compare(b.start, a.start);
        if (c != 0) return c;
        return Integer.compare(a.i, b.i);
    }
}

class EarlyEndComp implements Comparator<P> {
    @Override
    public int compare(P a, P b) {
        int c = Integer.compare(a.end, b.end);
        if (c!=0) return c;
        return Integer.compare(a.i, b.i);
    }
}

class Solution {
    static int INF = 1000000000;
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> r = new ArrayList<>();
        TreeSet<P> sets = new TreeSet<>(new LastStartComp());
        TreeSet<P> sete = new TreeSet<>(new EarlyEndComp());
        for (int i = 0; i < schedule.size(); i+=1) {
            List<Interval> li = schedule.get(i);
            P p;
            if (li.isEmpty()) {
                p = new P(-1, INF, i, 0);
            } else {
                Interval v = li.get(0);
                p = new P(-1, v.start, i, 0);
            }
            sets.add(p);
            sete.add(p);
        }
        while (sete.first().end != INF) {
            P start = sets.first();
            P end = sete.first();
            while (start.start >= end.end) {
                while(start.start >= end.end) {
                    sets.remove(end);
                    sete.remove(end);
                    List<Interval> ni = schedule.get(end.i);
                    //System.out.println(""+end.start+" " + end.end +" " +end.i+ " "+end.j);
                    int s = ni.get(end.j).end;
                    int e;
                    if (end.j == ni.size() -1) {
                        e = INF;
                    } else {
                        e = ni.get(end.j + 1).start;
                    }
                    //System.out.println("a "+s+" "+e);
                    P p = new P(s,e, end.i, end.j +1);
                    sets.add(p);
                    sete.add(p);
                    end = sete.first();
                }
                start = sets.first();
            }
            
            if (end.end == INF) return r;
            if (start.start >=0) {
                r.add(new Interval(start.start, end.end));
            }
            sets.remove(end);
            sete.remove(end);
            List<Interval> ni = schedule.get(end.i); 
            //System.out.println("p "+end.start+" " + end.end +" " +end.i+ " "+end.j);
            int s = ni.get(end.j).end;
            int e;
            if (end.j == ni.size() -1) {
                e = INF;
            } else {
                e = ni.get(end.j + 1).start;
            }
            P p = new P(s,e, end.i, end.j +1);
            sets.add(p);
            sete.add(p);
        }
        return r;
    }
    
}