public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String,Integer> L_set = new HashMap<String,Integer>();
        for(String s : L) {
            Integer v = L_set.get(s);
            if (v == null) v=0; 
            ++v;
            L_set.put(s,v);
        }
        
        HashMap<String, Integer> current = new HashMap<String,Integer>();
        int currentSize = 0;
        int wordLen = L[0].length();
        
        for (int i=0;i<wordLen;++i) {
            int start = i;
            int pos = i;
            current.clear(); currentSize = 0;
            while(pos + wordLen <= S.length()){
                String s = S.substring(pos,pos + wordLen);
                pos += wordLen;
                
                if (L_set.get(s) == null) {
                    current.clear(); currentSize = 0;
                    start = pos;
                } else {
                    Integer c = current.get(s);
                    if ( c==null) c = 0; 
                    if (c < L_set.get(s)) {
                        current.put(s,c+1); currentSize++;
                    } else {
                        while(true){
                            String t = S.substring(start,start + wordLen);
                            start += wordLen;
                            if (t.equals(s)) break;
                            currentSize--;
                            c = current.get(t);
                            current.put(t,c-1);
                        }
                    }
                    
                    if (currentSize==L.length) {
                        result.add(start);
                    }
                }
            }
        }
        
        return result;
    }
}
