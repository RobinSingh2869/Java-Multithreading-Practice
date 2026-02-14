package Executor_Framework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main4 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println("Task executed after 5 seconds"),
                5, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> System.out.println("Task executed every 5 seconds"),
                5, 5, TimeUnit.SECONDS);

        ScheduledFuture<?> scheduledFuture = scheduler.scheduleWithFixedDelay(() -> System.out.println("Task executed every 5 seconds"),
                5, 5, TimeUnit.SECONDS);

//        Thread.sleep(6000);
        ScheduledFuture<?> schedule = scheduler.schedule(() -> {
            System.out.println("Initiating shutdown.....");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
    }
}