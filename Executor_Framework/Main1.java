package Executor_Framework;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.concurrent.*;

public class Main1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable <String> callable = () -> "Hello";
        Future<?> future  = executorService.submit(callable);
        System.out.println(future.get());
        Thread.sleep(2000);
        executorService.shutdown();
        System.out.println(executorService.isTerminated());
//        executorService.submit(() -> System.out.println("Hello"), "abc");






//        if (future.isDone()){
//            System.out.println("Task is done !");
//        }
//        System.out.println(future.get());
        executorService.shutdown();
    }
}
