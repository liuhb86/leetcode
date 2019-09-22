import java.util.concurrent.CyclicBarrier;
class FizzBuzz {
    private static CyclicBarrier barrier = new CyclicBarrier(4);
    private int n;
    
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        try {
            for(int i=1; i<=n; i++) {
                if (i% 15 != 0 && i%3==0) printFizz.run();
                barrier.await();
            }
        } catch (BrokenBarrierException e) {}
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        try {
            for(int i=1; i<=n; i++) {
                if (i%15 != 0 && i%5==0) printBuzz.run();
                barrier.await();
            }
        } catch (BrokenBarrierException e) {}

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        try {
            for(int i=1; i<=n; i++) {
                if (i%15==0) printFizzBuzz.run();
                barrier.await();
            }
        } catch (BrokenBarrierException e) {}
            
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        try {
            for(int i=1; i<=n; i++) {
                if (i%3 != 0 && i%5!=0) printNumber.accept(i);
                barrier.await();
            }
        } catch (BrokenBarrierException e) {}
    }
}