package Executor_Framework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable callable  = () -> {
            Thread.sleep(1000);
            System.out.println("Task 1");
            return 1;
        };
        Callable callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 2");
            return 2;
        };
        Callable callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable, callable1, callable2);
//        List<Future<Integer>> futures = executorService.invokeAll(list);
//        List<Future<Integer>> futures1 = executorService.invokeAll(list, 1,TimeUnit.SECONDS);
        Integer i = executorService.invokeAny(list);
        System.out.println(i);

        executorService.shutdown();
    }
}
