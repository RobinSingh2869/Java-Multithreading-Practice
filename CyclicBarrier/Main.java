package CyclicBarrier;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfServices = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfServices);
        CyclicBarrier barrier = new CyclicBarrier(numberOfServices);
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));
        executorService.submit(new DependentService(barrier));

        System.out.println("Main");

        executorService.shutdown();

    }
}
class DependentService implements Callable<String>{

    private final CyclicBarrier barrier;

    public DependentService(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " Service Started ");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " is waiting at the barrier ");
        barrier.await();
        System.out.println(Thread.currentThread().getName() + " passed the barrier");
        return "ok";
    }
}
