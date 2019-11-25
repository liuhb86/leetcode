/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
import java.net.*;
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Context context = new Context();
        try {
            context.hostname = new URI(startUrl).getHost();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        context.parser = htmlParser;
        int numWorkers = 8;
        List<Thread> executors = new ArrayList<>();
        for (int i = 0; i < numWorkers; i += 1) {
            Thread t = new Thread(new CrawlWorker(context));
            t.start();
            executors.add(t);
        }
        context.remaining.getAndIncrement();
        context.queue.add(startUrl);
        for (Thread t : executors) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return new ArrayList<String>(context.crawled.keySet());
    }
}

class Context {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(10000);
    String hostname;
    ConcurrentHashMap<String, Boolean> crawled = new ConcurrentHashMap<>();
    HtmlParser parser;
    AtomicLong remaining = new AtomicLong();
}

class CrawlWorker implements Runnable{
    Context context;
    public CrawlWorker(Context context) {
       this.context = context;
    }
    
    @Override
    public void run() {
        while(true) {
            String url;
            try {
                url = context.queue.take();
            } catch (InterruptedException e) {
                return;
            }
            // System.out.println(url);
            if (url.equals("STOP")) {
                context.queue.add("STOP");
                return;
            }
            if (!context.crawled.containsKey(url)) {
                
                context.crawled.put(url, true);
                for (String child : context.parser.getUrls(url)) {
                    try {
                        URI uri = new URI(child);
                        if (context.hostname.equals(uri.getHost()) && !context.crawled.containsKey(child)) {
                            context.remaining.getAndIncrement();
                            context.queue.add(child);
                        }
                    } catch (URISyntaxException e) {
                        System.out.println(e);
                    }
                }
            }
            if (context.remaining.decrementAndGet() == 0) {
                context.queue.add("STOP");
                return;
            }
        }    
    }
}