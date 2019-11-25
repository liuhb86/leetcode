class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        for (String product: products) {
            Node p = root;
            for (int i = 0; i < product.length(); i += 1) {
                int offset = product.charAt(i) - 'a';
                if (p.children[offset] == null) {
                    p.children[offset] = new Node();
                }
                p = p.children[offset];
            }
            p.count += 1;
        }
        List<List<String>> result = new ArrayList<>();
        List<Character> prefix = new ArrayList<>();
        Node p = root;
        for (int i = 0; i < searchWord.length(); i += 1) {
            int offset = searchWord.charAt(i) - 'a';
            prefix.add(searchWord.charAt(i));
            if (p != null) p = p.children[offset];
            if (p == null) {
                result.add(Collections.emptyList());
            } else {
                List<String> top3 = new ArrayList<>();
                getTop3(p, top3, prefix);
                result.add(top3);
            }
        }
        return result;
    }
    private void getTop3(Node p, List<String> result, List<Character> prefix) {
        if (p.count > 0) {
            StringBuilder sb = new StringBuilder();
            for (char c: prefix) {
                sb.append(c);
            }
            int r = Math.min(p.count, 3 - result.size());
            String w = sb.toString();
            for (int i = 0; i < r; i+=1) result.add(w);
            if (result.size() == 3) return;
        }
        for (int i = 0; i < 26; i += 1) {
            if (p.children[i] != null) {
                prefix.add((char)('a' + i));
                getTop3(p.children[i], result, prefix);
                prefix.remove(prefix.size() - 1);
                if (result.size() == 3) return;
            }
        }
    }
}

class Node {
    Node[] children = new Node[26];
    int count = 0;
}