package Thread_lifecycle;

public class lifecycle extends Thread {
    public static void main(String[] args) throws InterruptedException {
        lifecycle t1 = new lifecycle();
        System.out.println("After creation: " + t1.getState()); // NEW
        t1.start();
        System.out.println("After start: " + t1.getState()); // RUNNABLE

        Thread.sleep(100);
        System.out.println("After sleep: " + t1.getState()); // TIMED_WAITING or RUNNABLE
        t1.join();
        System.out.println("After join: " + t1.getState()); // TERMINATED
    }

    @Override
    public void run() {
        System.out.println("Inside run(): " + Thread.currentThread().getState());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
