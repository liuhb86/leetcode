class BoundedBlockingQueue {
    
    int capacity;
    Queue<Integer> q = new ArrayDeque<>();
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        try {
            lock.lock();
            while (q.size() >= capacity) {
                notFull.await();
            }
            q.add(element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        try {
            lock.lock();
            while(q.isEmpty()) {
                notEmpty.await();
            }
            int v = q.remove();
            notFull.signal();
            return v;
        } finally {
            lock.unlock();
        }
    }
    
    public int size() {
        try {
            lock.lock();
            return q.size();
        } finally {
            lock.unlock();
        }
    }
}