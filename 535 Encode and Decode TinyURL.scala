public class Codec {
    
    private long id = 0;
    private HashMap<String, String> rev = new HashMap<>();
    private HashMap<String, String> rec = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String s = rev.get(longUrl);
        if (s != null) return s;
        String newId = Long.toString(id);
        id += 1;
        rec.put(newId, longUrl);
        rev.put(longUrl, newId);
        return newId;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return rec.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));