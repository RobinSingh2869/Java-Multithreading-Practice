package Thread_lifecycle;
public class Test extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Test t1 = new Test();
        System.out.println(t1.getState()); //NEW
        t1.start();
        System.out.println(t1.getState()); //RUNNABLE

//        System.out.println(Thread.currentThread().getState());
        Thread.sleep(100);
        System.out.println(t1.getState()); //TIMED WAITING
        t1.join();
        System.out.println(t1.getState()); //Terminated
    }

    @Override
    public void run() {
        System.out.println("Running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
