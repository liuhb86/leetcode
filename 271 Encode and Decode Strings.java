public class Codec {
    final String sep = "\u2000";
    final String emp = "\u2001";
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.isEmpty()) return emp;
        return String.join(sep, strs);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(emp)) return Collections.emptyList();
        return Arrays.asList(s.split(sep,-1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));