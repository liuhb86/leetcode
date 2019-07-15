import java.util.concurrent.Semaphore;

class H2O {

    Semaphore sh = new Semaphore(2);
    Semaphore so = new Semaphore(0);
    
    
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		sh.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        so.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        so.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
		releaseOxygen.run();
        sh.release(2);
    }
}