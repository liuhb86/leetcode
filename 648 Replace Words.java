class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Node root = new Node();
        for (String w : dict) {
            Node p = root;
            for (int i = 0; i < w.length(); i+=1) {
                char c = w.charAt(i);
                p = p.getOrCreate(c);
            }
            p.terminal = true;
        }
        
        StringBuilder r = new StringBuilder();
        int i = 0;
        while (i < sentence.length()) {
            int j = replace(sentence, i, root);
            if (j>=0) {
                for (int k=i; k < j; k+=1) r.append(sentence.charAt(k));
                i = j;
                while (i < sentence.length() && sentence.charAt(i)!=' ') i +=1;
            } else {
                while (i < sentence.length() && sentence.charAt(i) != ' ') {
                    r.append(sentence.charAt(i));
                    i+=1;
                }
            }
            if (i<sentence.length()) {
                r.append(' ');
                i+=1;
            }
        }
        return r.toString();
    }
    
    int replace(String w, int i, Node root) {
        Node p = root;
        while (i<w.length()) {
            char c = w.charAt(i);
            if (c == ' ') return i;
            p = p.children[c-'a'];
            if (p== null) return -1;
            if (p.terminal) return i + 1;
            i += 1;
        }
        return i;
    }
}

class Node{
    public Node[] children = new Node[26];
    public boolean terminal = false;
    public Node getOrCreate(char c) {
        int i = c - 'a';
        if (children[i] == null) children[i] = new Node();
        return children[i];
    }
}