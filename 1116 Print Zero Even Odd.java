import java.util.concurrent.Semaphore;
class ZeroEvenOdd {
    private int n;
    int next = 1;
    Semaphore s0 = new Semaphore(1);
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            s0.acquire();
            if (next > n) {
                s1.release();
                s2.release();
                return;
            }
            printNumber.accept(0);
            if (next % 2 == 0) s2.release(); else s1.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            s2.acquire();
            if (next > n) return;
            printNumber.accept(next);
            next += 1;
            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            s1.acquire();
            if (next > n) return;
            printNumber.accept(next);
            next += 1;
            s0.release();
        }        
    }
}