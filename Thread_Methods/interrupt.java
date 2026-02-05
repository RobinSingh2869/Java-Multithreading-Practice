package Thread_Methods;

public class interrupt extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread is Running.... ");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
//            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        interrupt t1 = new interrupt();
        t1.start();
        t1.interrupt();
    }
}
