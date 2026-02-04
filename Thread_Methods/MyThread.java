package Thread_Methods;

public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start() ;
        t1.join();
        System.out.println("Hello");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread is Running...");
    }
}
//start, run, sleep, join.
