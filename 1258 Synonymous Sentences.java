class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        // union find
        Map<String, String> parent = new HashMap<>();
        for (List<String> syn : synonyms) {
            String word0 = syn.get(0);
            String word1 = syn.get(1);
            String p0 = uf(word0, parent);
            String p1 = uf(word1, parent);
            if (!p0.equals(p1)) {
                parent.put(p1, p0);
            }
        }
        
        Map<String, List<String>> lists = new HashMap<>();
        for (String word : parent.keySet()) {
            String p = uf(word, parent);
            List<String> list = lists.get(p);
            if (list == null) {
                list = new ArrayList<String>();
                lists.put(p, list);
            }
            list.add(word);
        }
        
        Map<String, List<String>> dic = new HashMap<>();
        for (List<String> list : lists.values()) {
            Collections.sort(list);
            for (String word : list) {
                dic.put(word, list);
            }
        }   
        
        List<String> result = new LinkedList<>();
        generate(text.split(" "), 0, "", dic, result);
        return result;
    }
    
    private void generate(String[] words, int i, String prefix, Map<String, List<String>> dic, List<String> result) {
        if (i >= words.length) {
            result.add(prefix);
            return;
        }
        if (prefix.length() > 0) prefix = prefix + " ";
        String word = words[i];
        List<String> syn = dic.get(word);
        if (syn == null) {
            generate(words, i+1, prefix+word, dic, result);
        } else {
            for (String s : syn) {
                generate(words, i+1, prefix+s, dic, result);
            }
        }
    }
    
    private String uf(String word, Map<String, String> parent) {
        String p = parent.get(word);
        if (p == null) {
            parent.put(word, word);
            return word;
        }
        if (p.equals(word)) {
            return word;
        }
        p = uf(p, parent);
        parent.put(word, p);
        return p;
    }
}