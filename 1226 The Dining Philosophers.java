class DiningPhilosophers {
    
    ReentrantLock[] locks = new ReentrantLock[5];
    
    Lock xxx = new ReentrantLock();
    
    public DiningPhilosophers() {
        for (int i = 0; i < 5; i += 1) {
            locks[i] = new ReentrantLock(true);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        xxx.lock();
        if (philosopher != 4) {
            locks[philosopher].lock();
            pickLeftFork.run();
            locks[philosopher+1].lock();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            locks[philosopher+1].unlock();
            putLeftFork.run();
            locks[philosopher].unlock();
        } else {
            locks[0].lock();
            pickRightFork.run();
            locks[4].lock();
            pickLeftFork.run();
            eat.run();
            putLeftFork.run();
            locks[4].unlock();
            putRightFork.run();
            locks[0].unlock();
        }
        xxx.unlock();
    }
}