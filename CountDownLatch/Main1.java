package CountDownLatch;

import java.util.concurrent.*;

public class Main1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        for (int i = 0; i <numberOfServices ; i++) {
            new Thread(new dependentservice(latch)).start();
        }

        latch.await(5,TimeUnit.SECONDS);
        System.out.println("Main");

    }
}
class dependentservice implements Runnable{

    private final CountDownLatch latch;
    public dependentservice(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run()  {
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " Service Started ");
        } catch (InterruptedException e) {

        }finally {
            latch.countDown();
        }
    }
}
