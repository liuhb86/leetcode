import java.util.concurrent.Semaphore;
class Foo {

    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);
        
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        s3.release();
    }
}