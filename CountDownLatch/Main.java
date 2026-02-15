package CountDownLatch;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CountDownLatch latch = new CountDownLatch(numberOfServices);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();

        System.out.println("Main");
        executorService.shutdown();

    }
}
class DependentService implements Callable<String>{

    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Service Started ");
        Thread.sleep(2000);
        latch.countDown();
        return "ok";
    }
}
