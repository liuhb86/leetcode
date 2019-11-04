/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> r = new HashSet<>();
        String hostname = getHost(startUrl);
        crawl(startUrl, htmlParser, hostname, r);
        List<String> rl = new ArrayList<>();
        for (String s: r) {
            rl.add(s);
        }
        return rl;
    }
    
    void crawl(String url, HtmlParser htmlParser, String host, Set<String> result) {
        if (result.contains(url)) return;
        result.add(url);
        List<String> links = htmlParser.getUrls(url);
        for (String link : links) {
            if (getHost(link).equals(host)) {
                crawl(link, htmlParser, host, result);
            }
        }
    }
    
    String getHost(String url) {
        int e = url.indexOf('/', 7);
        if (e>=0 ) return url.substring(7,e);
        else return url.substring(7);
    }
    
}